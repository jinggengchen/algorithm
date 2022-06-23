package LeetCode.排序查找;

/**
 * https://www.cnblogs.com/kyoner/p/11080078.html
 */
public class NC_105_Search {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,2,2};
        System.out.println(search2(nums, 2));
    }
    // 正常的二分搜索：
    // 但是有一个缺陷：{1,2,2,2,2,2,2} 如果给了这样一个值，他返回的不是第一个2出现的位置。如果想要找第一个出现的位置，代码需要优化
    public static int search (int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        // 为什么 <= 不是 <  答：因为R = nums.length - 1,即最后一个数字的索引位置。
        // <= 相当于 两边都是闭区间， < 相当于是左闭右开
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid - 1;
            // 找到 target 时不要立即返回，而是缩小「搜索区间」的上界 right，
            // 在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。
            } else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }


    // 寻找左侧边界的二分查找：
    public static int search1 (int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int L = 0;
        int R = nums.length;
        // 为什么 <= 不是 <  答：因为R = nums.length - 1,即最后一个数字的索引位置。
        // <= 相当于 两边都是闭区间， < 相当于是左闭右开
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid;
            } else if (nums[mid] == target){
                R = mid;
            }
        }
        // 最右边都没有找到 返回-1
        if (L == nums.length) return -1;
        return nums[L] == target ? L : -1;
    }
    // 寻找右侧边界的二分查找：
    public static int search2 (int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int L = 0;
        int R = nums.length;
        // <= 相当于 两边都是闭区间， < 相当于是左闭右开
        while (L < R) {
            int mid = L + (R - L) / 2;
            // 中间值 比 目标 小，说明目标值在右边
            if (nums[mid] < target) {
                L = mid + 1;
            // 中间值 比 目标 小，说明目标值在右边
            } else if (nums[mid] > target) {
                R = mid;
            // nums[mid] == target 时，不要立即返回，而是增大「搜索区间」的下界 left，
            // 使得区间不断向右收缩，达到锁定右侧边界的目的。
            } else if (nums[mid] == target){
                L = mid + 1;
            }
        }
        if (L == 0) return -1;
        return nums[L - 1] == target ? L - 1 : -1;
    }

    /**
     * 最基本的二分：
     * 因为我们初始化 right = nums.length - 1
     * 所以决定了我们的「搜索区间」是 [left, right]
     * 所以决定了 while (left <= right)
     * 同时也决定了 left = mid+1 和 right = mid-1
     *
     * 因为我们只需找到一个 target 的索引即可
     * 所以当 nums[mid] == target 时可以立即返回
     */

    /**
     * 最左侧的二分
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid+1 和 right = mid
     *
     * 因为我们需找到 target 的最左侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧右侧边界以锁定左侧边界
     */
}
