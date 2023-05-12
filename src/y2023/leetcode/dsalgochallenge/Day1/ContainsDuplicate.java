package y2023.leetcode.dsalgochallenge.Day1;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        int a[] = {2, 14, 18, 22, -2, -3, -2};
        System.out.println(obj.duplicate(a));
    }

    boolean duplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    boolean duplicate1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    boolean duplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
