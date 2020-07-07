package recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSorting {
    public static void main(String[] args) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(1);
        left.add(11);
        left.add(111);
        left.add(1111);
        right.add(2);
        right.add(66);
        right.add(25);
        right.add(212);
        right.add(28);
        right.add(23);
        right.add(22222);
        right.add(29);
        List<Integer> merge = new ArrayList<>();
        int[] list = new int[] {
            11, 3, 23, 3, 1, 44, 23, 112, 100, 99
        } ;
        mergeSort(list, list.length);
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
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
}
