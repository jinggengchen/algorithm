package LeetCode.模拟;

import java.util.Stack;

public class 栈实现队列 {
    public static void main(String[] args) {
        put(1);
        put(2);
        put(3);
        pop();
        pop();

    }
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void put(int value) {
        stack1.push(value);
    }
    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return -1;
        }
    }
}
