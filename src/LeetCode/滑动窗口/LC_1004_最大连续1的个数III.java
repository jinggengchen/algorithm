package LeetCode.滑动窗口;

/**
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */
public class LC_1004_最大连续1的个数III {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));

    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = 0;
        int zeroCount = 0;
        while (right < nums.length) {
            int num = nums[right];
            if (num == 0) {
                zeroCount ++;
            }
            while (zeroCount > k) {
                int n = nums[left];
                if (n == 0) {
                    zeroCount --;
                }
                left ++;
            }
            res = Math.max(res, right - left +1);

            right ++;
        }
        return res;
    }
}
