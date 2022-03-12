package LeetCode;

import java.util.*;

public class LC_239_滑动窗口最大值 {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll() + " ");


        int[] nums = {1,3,-1,-3,5,3,6,7};
        List<Integer> integers = maxSlidingWindow(nums, 3);
        System.out.println(integers);
    }
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <2) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>((x,y) -> y - x);
        int left = 0, right = 0;
        while (right < nums.length) {
            queue.add(nums[right]);
            if (right - left + 1 == k) {
                list.add(queue.peek());
                queue.remove(nums[left]);
                left++;
            }
            right++;
        }
        return list;

    }

}
