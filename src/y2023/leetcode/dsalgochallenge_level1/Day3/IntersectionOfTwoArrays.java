package y2023.leetcode.dsalgochallenge_level1.Day3;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {9, 4, 9, 8, 4};
        int[] nums2 = {4, 5, 9};
        IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
        int ans[] = obj.intersectSortedArray(nums1, nums2);
        Arrays.stream(ans).forEach(System.out::println);

    }

    //UsingMap
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int j = 0, k = 0;
        while (j < nums2.length) {
            int count = map.getOrDefault(nums2[j], 0);
            if (count > 0) {
                nums1[k] = nums2[j];
                map.put(nums2[j], count - 1);
                k++;
            }
            j++;

        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    //Using Sorted Array

    public int[] intersectSortedArray(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
