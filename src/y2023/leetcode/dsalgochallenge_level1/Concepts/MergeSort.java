package y2023.leetcode.dsalgochallenge_level1.Concepts;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {9, 8, 7, 6, 5, 2};
        MergeSort obj = new MergeSort();
        obj.mergeSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(System.out::println);
    }

    void mergeSort(int a[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);

        }
    }

    void merge(int a[], int left, int mid, int right) {
        int i = 0, j = 0, k = left;

        int leftArray[] = new int[mid - left + 1];
        int rightArray[] = new int[right - mid];

        for (int l = 0; l < leftArray.length; l++) {
            leftArray[l] = a[left + l];
        }

        for (int r = 0; r < rightArray.length; r++) {
            rightArray[r] = a[mid + 1 + r];
        }

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] >= rightArray[j]) {
                a[k] = rightArray[j];
                k++;
                j++;
            } else {
                a[k] = leftArray[i];
                k++;
                i++;
            }
        }
        while (i < leftArray.length) {
            a[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            a[k] = rightArray[j];
            j++;
            k++;
        }

    }

}
