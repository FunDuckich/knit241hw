package org.knit.solutions.lab6sem2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ZeroDuplicatorTest {

    private final ZeroDuplicator duplicator = new ZeroDuplicator();

    @Test
    void testExample1() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] expected = {1, 0, 0, 2, 3, 0, 0, 4};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testExample2NoZeros() {
        int[] arr = {1, 2, 3};
        int[] expected = {1, 2, 3};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testNullArray() {
        int[] arr = null;
        assertDoesNotThrow(() -> duplicator.duplicateZeros(arr));
        assertNull(arr);
    }

    @Test
    void testAllZerosNoSpaceToDuplicate() {
        int[] arr = {0, 0, 0};
        int[] expected = {0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAllZerosWithSomeSpace() {
        int[] arr = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }


    @Test
    void testSingleZeroAtStart() {
        int[] arr = {0, 1, 2};
        int[] expected = {0, 0, 1};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleZeroInMiddle() {
        int[] arr = {1, 0, 2};
        int[] expected = {1, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleZeroAtEndNoSpace() {
        int[] arr = {1, 2, 0};
        int[] expected = {1, 2, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testZerosAtEndTruncated() {
        int[] arr = {1, 2, 0, 0};
        int[] expected = {1, 2, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr, "Массив: " + Arrays.toString(arr));
    }
    @Test
    void testZerosAtEndWithSpaceForOneDuplicate() {
        int[] arr_tc = {1,0,0,0,5};
        int[] expected_tc = {1,0,0,0,0};
        duplicator.duplicateZeros(arr_tc);
        assertArrayEquals(expected_tc, arr_tc, "Массив: " + Arrays.toString(arr_tc));
    }


    @Test
    void testMultipleZerosOverflow() {
        int[] arr = {0, 0, 1, 0};
        int[] expected = {0, 0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr, "Массив: " + Arrays.toString(arr));
    }

    @Test
    void testOnlySpaceForOneZeroDuplicate() {
        int[] arr = {0, 3, 0, 4};
        int[] expected = {0, 0, 3, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr, "Массив: " + Arrays.toString(arr));
    }

    @Test
    void testMixedValuesWithTruncation() {
        int[] arr = {8, 4, 0, 9, 0, 0, 0, 8};
        int[] expected = {8, 4, 0, 0, 9, 0, 0, 0};
        duplicator.duplicateZeros(arr);
        assertArrayEquals(expected, arr, "Массив: " + Arrays.toString(arr));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testPerformanceLargeArrayManyZeros() {
        int size = 10000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i % 2 == 0) ? 0 : i % 10;
        }
        long startTime = System.nanoTime();
        assertDoesNotThrow(() -> duplicator.duplicateZeros(arr));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Производительность (много нулей, размер " + size + "): " + duration + " мс");
        assertTrue(duration < 150, "Тест производительности (много нулей) занял слишком много времени: " + duration + " мс");
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testPerformanceLargeArrayFewZeros() {
        int size = 10000;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = (random.nextInt(100) < 5) ? 0 : (random.nextInt(9) + 1);
        }
        long startTime = System.nanoTime();
        assertDoesNotThrow(() -> duplicator.duplicateZeros(arr));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Производительность (мало нулей, размер " + size + "): " + duration + " мс");
        assertTrue(duration < 80, "Тест производительности (мало нулей) занял слишком много времени: " + duration + " мс");
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void testPerformanceLargeArrayNoZeros() {
        int size = 10000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i % 9) + 1;
        }
        long startTime = System.nanoTime();
        assertDoesNotThrow(() -> duplicator.duplicateZeros(arr));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Производительность (нет нулей, размер " + size + "): " + duration + " мс");
        assertTrue(duration < 50, "Тест производительности (нет нулей) занял слишком много времени: " + duration + " мс");
    }
}
