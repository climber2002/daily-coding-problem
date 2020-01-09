package com.dailyCodingProblem;

import java.util.Stack;
import java.util.Arrays;

public class P274 {
    /**
     * This problem was asked by Facebook.
     *
     * Given a string consisting of parentheses, single digits, and positive and negative
     * signs, convert the string into a mathematical expression to obtain the answer.
     *
     * Don't use eval or a similar built-in parser.
     *
     * For example, given '-1 + (2 + 3)', you should return 4
     * @param str
     * @return
     */
    public static int eval(String str) {
        char[] chars = str.toCharArray();
        Stack<String> stack = new Stack<>();
        for(char c : chars) {
            if(isOperator(c) || isDigit(c) || isLeftParenthese(c)) {
                stack.push(Character.toString(c));
            } else if(isRightParenthese(c)) {
                Stack<String> frame = getCurrentFrame(stack);
                int frameResult = calculateCurrentFrame(frame);
                stack.push(Integer.toString(frameResult));
            }
        }
        System.out.println(Arrays.toString(stack.toArray()));
        return calculateCurrentFrame(getCurrentFrame(stack));
    }

    public static int calculateCurrentFrame(Stack<String> frame) {
        if(frame.isEmpty()) {
            return 0;
        }
        Stack<Integer> temp = new Stack<>();
        if(isOperatorString(frame.peek())) {
            temp.push(0);
        }

        while(!frame.isEmpty()) {
            String c = frame.pop();
            if(isOperatorString(c)) {
                int left = temp.pop();
                int right = Integer.parseInt(frame.pop());
                if(c.equals("+")) {
                    temp.push(left + right);
                } else {
                    temp.push(left - right);
                }
            } else{
                temp.push(Integer.parseInt(c));
            }
        }

        return temp.pop();
    }

    private static Stack<String> getCurrentFrame(Stack<String> chars) {
        Stack<String> result = new Stack<>();
        while(!chars.isEmpty() && !isLeftParentheseString(chars.peek())) {
            String c = chars.pop();
            result.push(c);
        }
        if(!chars.isEmpty() && isLeftParentheseString(chars.peek())) {
            chars.pop();
        }
        return result;
    }

    private static boolean isOperatorString(String c) {
        return c.equals("+") || c.equals("-");
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-';
    }

    private static boolean isDigit(char c) {
        return c == '1' ||
                c == '2' ||
                c == '3' ||
                c == '4' ||
                c == '5' ||
                c == '6' ||
                c == '7' ||
                c == '8' ||
                c == '9' ||
                c == '0';
    }

    public static boolean isLeftParentheseString(String c) {
        return c.equals("(");
    }

    public static boolean isLeftParenthese(char c) {
        return c == '(';
    }

    public static boolean isRightParenthese(char c) {
        return c == ')';
    }
}
