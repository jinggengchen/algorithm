package LeetCode.最;

import java.util.Arrays;

public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(method(arr));
    }
    // dp[i] 表示当前位置最长上升子序列的长度
    // dp[i] = arr[i] < arr[j] dp[i] = max

    public static int method(int[] arr) {
        int res = 0;
        int[] dp = new int[arr.length +1];
        Arrays.fill(dp, 1);
        // j 是左指针
        // i 是右指针 i不断的向右移动
        // dp[i] 表示以i位置的最长上升子序列
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
