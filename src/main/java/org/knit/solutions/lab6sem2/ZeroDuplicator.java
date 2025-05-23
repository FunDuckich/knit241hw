package org.knit.solutions.lab6sem2;

public class ZeroDuplicator {
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        int zeros = 0;
        for (int x : arr) {
            if (x == 0) {
                zeros++;
            }
        }

        if (zeros == 0) {
            return;
        }

        int i = n - 1;
        int j = n - 1 + zeros;

        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            j--;

            if (arr[i] == 0) {
                if (j < n) {
                    arr[j] = 0;
                }
                j--;
            }
            i--;
        }
    }
}
