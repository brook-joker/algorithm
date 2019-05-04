package leetcode;

import java.util.Stack;

public class Leet20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else {
                    stack.add(c);
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                }else {
                    stack.add(c);
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }else {
                    stack.add(c);
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
