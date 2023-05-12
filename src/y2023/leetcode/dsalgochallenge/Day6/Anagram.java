package y2023.leetcode.dsalgochallenge.Day6;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        Anagram obj = new Anagram();
        boolean ans = obj.isAnagram2(str1, str2);
        System.out.println(ans);
    }

    //Sorting
    public boolean isAnagram(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        System.out.println(s1.toString());
        if (String.valueOf(s1).equals(String.valueOf(s2))) {
            return true;
        }
        return false;
    }

    //using map
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 2) - 1);
        }

        for (Integer i : map.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    //using counters
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int ch[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ch[(s.charAt(i) - 'a')]++;
            ch[(t.charAt(i)) - 'a']--;
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
