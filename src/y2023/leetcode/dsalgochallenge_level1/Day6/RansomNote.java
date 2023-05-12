package y2023.leetcode.dsalgochallenge_level1.Day6;

import java.util.*;

public class RansomNote {
    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "aab";
        RansomNote obj = new RansomNote();
        boolean ans = obj.canConstruct1(str1, str2);
        System.out.println(ans);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ch = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            ch[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int cnt = ch[magazine.charAt(i) - 'a'];
            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> sortedStack(char[] ch) {
        Arrays.sort(ch);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            stack.push(ch[i]);
        }
        return stack;
    }

    //Using Stack
    public boolean canConstruct1(String ransomNote, String magazine) {
        Stack<Character> stack1 = sortedStack(ransomNote.toCharArray());
        Stack<Character> stack2 = sortedStack(magazine.toCharArray());

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek().equals(stack2.peek())) {
                stack1.pop();
                stack2.pop();
            } else if (stack1.peek() < stack2.peek()) {
                stack2.pop();
            } else return false;
        }
        return stack1.isEmpty();
    }

    //Using subString
    public boolean canConstruct2(String ransomNote, String magazine) {
        for (char r : ransomNote.toCharArray()) {
            int index = magazine.indexOf(r);
            if (index == -1) {
                return false;
            }
            magazine = magazine.substring(0, index) + magazine.substring(index + 1, magazine.length());
        }
        return true;
    }
    //Using HashMap we already did it for Anagram of String
}
