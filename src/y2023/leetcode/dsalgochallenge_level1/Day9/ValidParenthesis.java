package y2023.leetcode.dsalgochallenge_level1.Day9;

import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
        System.out.println(obj.isValid1("({{{{}}}))"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else {
                if (!stack.isEmpty() && removeChar(s.charAt(i), stack)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


    boolean removeChar(char ch, Stack stack) {
        switch (ch) {
            case ')':
                char a = (char) stack.peek();
                if (a == '(') {
                    stack.pop();
                    return true;
                } else return false;
            case ']':
                char b = (char) stack.peek();
                if (b == '[') {
                    stack.pop();
                    return true;
                } else return false;
            case '}':
                char c = (char) stack.peek();
                if (c == ('{')) {
                    stack.pop();
                    return true;
                } else return false;
            default:
                return false;
        }
    }

    private Map<Character, Character> map;

    ValidParenthesis() {
        this.map = new HashMap<>();
        this.map.put(')', '(');
        this.map.put('}', '{');
        this.map.put(']', '[');
    }

    //({{{{}}}))
    public boolean isValid1(String s) {


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                char ch = map.get(s.charAt(i));
                if (!stack.isEmpty() && ch == stack.peek()) {
                    stack.pop();
                } else return false;
            }
        }

        return stack.isEmpty();
   