package LeetCode.模拟;

import java.util.LinkedList;
import java.util.Queue;

public class 队列实现栈 {
    public static void main(String[] args) {
        // 当前数据库里面的值
        int features = 1;
        //
        int position = 1;
        System.out.println(1 << 1);
        System.out.println(1|2);
        System.out.println(features | (1 << position));
        System.out.println(features & ~(1 << position));



    }
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    public static void put(int value) {
        queue1.add(value);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public static int pop() {
        return queue2.poll();
    }
    public static int peek() {
        return queue2.peek();
    }
}
