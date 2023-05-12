package y2023.leetcode.dsalgochallenge_level1.Day2;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int a[] = {3,2,4};
        TwoSum obj = new TwoSum();
        Arrays.stream(obj.twoSum(a, 6)).forEach(System.out::println);
    }

    int[] twoSum(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum) && i <= sum && i != map.get(sum)) {
                return new int[]{i, map.get(sum)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
