package com.ym.jvm;

import java.util.ArrayList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        System.out.println(thousandSeparator(12345));
    }

    public static String thousandSeparator(int n) {
        int length = (n + "").length();
        if (n == 0 || length <= 3) {
            return n + "";
        }
        String str = n + "";
        Stack<String> stack = new Stack<>();
        int count = 0;
        while (n > 0) {
            int num = n % 10;
            stack.push(num + "");
            count++;
            n /= 10;
            if (count == 3 && n > 0) {
                stack.push(".");
                count = 0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
