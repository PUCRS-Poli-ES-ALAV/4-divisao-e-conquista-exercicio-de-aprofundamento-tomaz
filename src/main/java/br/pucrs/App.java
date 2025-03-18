package br.pucrs;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App
{
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
    private static int[] rng(int n){
        int[] a = new int[n];

        for(int i=n-1; i>0 ;i--){
            a[i]= i;
        }
        return a;
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
    public static void main( String[] args )
    {
        int[] a = new int[32];
        int[] b = new int[2042];
        int[] c = new int[1048576];
        a = rng(32);
        b = rng(2042);
        c = rng(1048576);
        System.out.println(a);
        mergeSort(a,32);

         mergeSort(b,2042);

         mergeSort(c,1048576);


        System.out.println(a);



    }
}
