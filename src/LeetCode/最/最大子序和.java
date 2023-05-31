package LeetCode.最;

import java.util.List;

public class 最大子序和 {
    public static void main(String[] args) {
        int arr[] = {-1,-4,2,5,3,-2};
        System.out.println(method(arr));
    }
    // [-1,-4,2,5,3,-2]
    public static int method(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int res = 0;
        // dp[i] 表示当前i位置的最大子序和
        // dp[i + 1]  1. dp[i] < 0  arr[i+1] : dp[i] + arr[i+1]
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i-1] >= 0) {
                dp[i] = dp[i-1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
