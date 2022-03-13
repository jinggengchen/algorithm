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
        int left = 0;
        int right = 0;
        int res = 0;
        int zere_count = 0;
        // 右指针每次都向右移动，移动的过程中判断0的个数，如果0的个数大于k，就说明需要移动左指针了
        // 左指针的移动的时候，如果该位置是0，就需要吧0的个数-1
        while (right < nums.length) {
            int num = nums[right];
            if (num == 0) {
                zere_count++;
            }
            while (zere_count > k) {
                if (nums[left] == 0) {
                    zere_count --;
                }
                left ++;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return  res;
    }
}
