package y2023.leetcode.dsalgochallenge.Day2;

import java.util.*;

public class MergeSortedArray {
    public static void main(String[] args) {
        int a[] = {4, 5, 6, 0, 0, 0,};
        int b[] = {1, 2, 3};
        MergeSortedArray obj = new MergeSortedArray();
        //obj.merge(a, 3, b, 3);
        obj.mergeWithoutTempArray(a, 3, b, 3);
    }

    // 1 1 2 3 4 8 9
    //Using Temp Array
    void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] >= nums2[j]) {
                temp[k] = nums2[j];
                j++;
                k++;
            } else {
                temp[k] = nums1[i];
                i++;
                k++;
            }
        }
        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        for (int l = 0; l < temp.length; l++) {
            nums1[l] = temp[l];
        }
        Arrays.stream(nums1).forEach(System.out::println);
    }

    // 4 5 6 4 5 6  1 2 3
    void mergeWithoutTempArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (k >= 0) {
            if (j < 0) {
                break;
            }
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        Arrays.stream(nums1).forEach(System.out::println);
    }
}


//Algorithm

/*
 *  1 3 5 0 0 0     2 4 5
 **
 *  res: 1
 * pt : 2 3
 *res 1 2 3 5 0 0
 *
 *
 *
 */
