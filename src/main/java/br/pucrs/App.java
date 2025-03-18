package br.pucrs;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App
{
    private static long iterations = 0;
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(a, mid, r, mid - mid, n - mid);
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    public static long maxVal1(long[] A, int n) {
        long max = A[0];
        for (int i = 1; i < n; i++) {
            iterations++;
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
    public static long maxVal2(long[] A, int init, int end) {
        iterations++;
        if (end - init <= 0) return A[init];
        if (end - init == 1) return Math.max(A[init], A[end]);
        int m = (init + end) / 2;
        long v1 = maxVal2(A, init, m);
        long v2 = maxVal2(A, m + 1, end);
        return Math.max(v1, v2);
    }
    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1_048_576};
        Random random = new Random();

        for (int size : sizes) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextLong();
            }

            iterations = 0;
            long startTime = System.nanoTime();
            long max = maxVal1(array, size);
            long endTime = System.nanoTime();

            System.out.println("Tamanho: " + size);
            System.out.println("Iterações: " + iterations);
            System.out.println("Tempo (ms): " + (endTime - startTime) / 1_000_000.0);
            System.out.println("Máximo: " + max);
            System.out.println();
        }
    }
}
