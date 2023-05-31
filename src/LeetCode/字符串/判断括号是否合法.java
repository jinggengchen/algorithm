package LeetCode.字符串;

import java.util.Stack;

public class 判断括号是否合法 {
    // 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
    //括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
    public static void main(String[] args) {
        System.out.println(method("()[]{}]"));
    }
    // ()[]{}
    public static boolean method(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            // 遇到左括号 入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 遇到右括号，判断栈顶元素是否和当前的匹配，如果匹配就删除栈顶元素
                char peek = stack.peek();
                if (peek == '(' && ch == ')' || peek == '[' && ch == ']' || peek == '{' && ch == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // 合法的括号，最后栈一定是空的。
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        /** }
         *  {
         *  ]
         *  [
         *  )
         *  (
         */


    }
}
