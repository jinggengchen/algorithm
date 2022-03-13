package LeetCode.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 子字符串 "ece" 长度为 3.
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 子字符串 "aa" 长度为 2.
 */
public class LC_340_至多包含K个不同字符的最长子串 {
    public static void main(String[] args) {
        int eceab = lengthOfLongestSubstringKDistinct("eceab", 3);
        System.out.println(eceab);
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0;
        char[] ss = s.toCharArray();
        //key为当前字符，value为当前字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while (right < ss.length) {
            char c = ss[right];
            map.put(c, map.getOrDefault(c,0) + 1);
            if (map.size() > k) {
                char b = ss[left];
                // 当前字符出现了一次，直接删除
                if (map.get(b) == 1) {
                    map.remove(b);
                } else {

                    // 当前字符出现了两次，次数-1
                    map.put(b,map.getOrDefault(b,0)-1);
                }
                left ++;
            }else {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right ++;
        }
        return maxLen;
    }
}
