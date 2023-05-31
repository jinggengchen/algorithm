package LeetCode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LC_46_全排列 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            return new ArrayList<>(new ArrayList<>(nums[0]));
        }
        dfs(0, nums);
        return res;
    }


    private static void dfs(int start, int[] nums) {

        if (start == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            res.add(cur);
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            dfs(start + 1, nums);
            swap(nums, i, start);
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
