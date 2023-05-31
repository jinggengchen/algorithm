package LeetCode.最;

public class 最长回文子串 {
    public static void main(String[] args) {
        // "aabbcc"
        // [0][1]
        // [0][2]
        System.out.println(method("aabcc"));
    }
    public static String method(String s) {
        char[] chars = s.toCharArray();
        // dp[i][j] 字符串从i到j位置是回文
        // dp[i][j]

        // i是左指针，
        // j是右指针
        int max = 0;
        int start = 1;
        boolean[][] dp = new boolean[chars.length + 1][ chars.length + 1];
        for (int k = 0; k < chars.length; k++) {
            dp[k][k] = false;
        }
        for (int j = 1; j < chars.length; j++) {
            // j不断右移动，i每次只能访问j之前的字符
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 取决于
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    // 滑动窗口
                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}
