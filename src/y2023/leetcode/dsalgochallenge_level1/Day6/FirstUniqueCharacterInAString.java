package y2023.leetcode.dsalgochallenge_level1.Day6;

import java.util.*;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String str = "leetcode";
        FirstUniqueCharacterInAString obj = new FirstUniqueCharacterInAString();
        obj.firstUniqChar(str);

    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        Arrays.sort(s.toCharArray());
        return 0;
    }
}
