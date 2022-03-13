package LeetCode.队列和栈;

import java.util.Stack;

public class LC_232_用栈实现队列 {
    class MyQueue {
        Stack<Integer> stackA;
        Stack<Integer> stackB;

        public MyQueue() {
            stackA = new Stack();
            stackB = new Stack();
        }

        public void push(int x) {
            stackA.push(x);
        }

        public int pop() {
            if (stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            if (!stackB.isEmpty()) {
                return stackB.pop();
            } else {
                return -1;
            }
        }

        public int peek() {
            if (stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            if (!stackB.isEmpty()) {
                return stackB.peek();
            } else {
                return -1;
            }
        }

        public boolean empty() {
            return stackA.isEmpty() && stackB.isEmpty();
        }
    }
}
