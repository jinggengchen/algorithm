package LeetCode.滑动窗口;

public class LC_485_最大连续1的个数 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,0,1,0,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 1) {
                count ++;
                res = Math.max(count, res);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
