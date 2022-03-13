package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 */
public class LC_395_至少有K个重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abcbba", 2));
    }
    public static int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (Character c : map.keySet()) {
            int res = 0;
            if (map.get(c) > k) {
                for (String s1 : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(s1,k));
                }
                return res;
            }

        }
        return s.length();
    }
}
