package org.knit.solutions.lab6sem2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMergerTest {

    private final ArrayMerger merger = new ArrayMerger();

    @Test
    void testExample1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testExample2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testExample3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testNums1EmptyInitially() {
        int[] nums1 = {0, 0, 0};
        int m = 0;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 3};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testNums2Empty() {
        int[] nums1 = {1, 2, 3};
        int m = 3;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1, 2, 3};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testBothEmptyParts() {
        int[] nums1_actual_empty = {};
        int m_actual_empty = 0;
        int[] nums2_actual_empty = {};
        int n_actual_empty = 0;
        int[] expected_actual_empty = {};
        merger.mergeSortedArrays(nums1_actual_empty, m_actual_empty, nums2_actual_empty, n_actual_empty);
        assertArrayEquals(expected_actual_empty, nums1_actual_empty);
    }

    @Test
    void testAllElementsFromNums1AreSmaller() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {4, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 3, 4, 5, 6};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testAllElementsFromNums2AreSmaller() {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 3, 4, 5, 6};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testWithDuplicates() {
        int[] nums1 = {1, 2, 2, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 3, 3, 6};
        int n = 4;
        int[] expected = {1, 2, 2, 2, 3, 3, 6};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testWithNegativeNumbers() {
        int[] nums1 = {-5, -2, 0, 0, 0, 0};
        int m = 2;
        int[] nums2 = {-6, -3, 1, 5};
        int n = 4;
        int[] expected = {-6, -5, -3, -2, 1, 5};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testMaxConstraints() {
        int m = 100;
        int n = 100;
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++) {
            nums1[i] = i * 2;
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = i * 2 + 1;
        }

        int[] expected = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            expected[i] = i;
        }

        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testMaxValues() {
        int[] nums1 = {1000000000, 0};
        int m = 1;
        int[] nums2 = {900000000};
        int n = 1;
        int[] expected = {900000000, 1000000000};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    void testMinValues() {
        int[] nums1 = {-1000000000, 0};
        int m = 1;
        int[] nums2 = {-2000000000};
        int n = 1;
        int[] expected = {-2000000000, -1000000000};
        merger.mergeSortedArrays(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }


    @Test
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void testPerformanceLargeArrays() {
        int m = 100;
        int n = 100;


        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            nums1[i] = random.nextInt(2000) - 1000;
        }
        Arrays.sort(nums1, 0, m);

        for (int i = 0; i < n; i++) {
            nums2[i] = random.nextInt(2000) - 1000;
        }
        Arrays.sort(nums2, 0, n);

        int[] tempCombined = new int[m + n];
        System.arraycopy(nums1, 0, tempCombined, 0, m);
        System.arraycopy(nums2, 0, tempCombined, m, n);
        Arrays.sort(tempCombined);

        long startTime = System.nanoTime();
        merger.mergeSortedArrays(nums1, m, nums2, n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Производительность (слияние массивов m=" + m + ", n=" + n + "): " + duration + " мс");

        assertArrayEquals(tempCombined, nums1, "Результат слияния не совпадает с ожидаемым отсортированным массивом");
        assertTrue(duration < 30, "Тест производительности занял слишком много времени: " + duration + " мс");
    }

    @Test
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void testPerformanceOneArrayEmpty() {
        int m = 200;
        int n = 0;

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            nums1[i] = random.nextInt(2000) - 1000;
        }
        Arrays.sort(nums1, 0, m);

        int[] expected = Arrays.copyOf(nums1, m + n);

        long startTime = System.nanoTime();
        merger.mergeSortedArrays(nums1, m, nums2, n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        System.out.println("Производительность (один массив пуст, m=" + m + ", n=" + n + "): " + duration + " мс");

        assertArrayEquals(expected, nums1);
        assertTrue(duration < 10, "Тест производительности (один массив пуст) занял слишком много времени: " + duration + " мс");
    }
}
