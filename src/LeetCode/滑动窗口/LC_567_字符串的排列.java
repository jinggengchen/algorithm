package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class LC_567_字符串的排列 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidboaoo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] ss = s1.toCharArray();
        char[] cc = s2.toCharArray();
        for (char s : ss) {
            need.put(s, need.getOrDefault(s, 0) + 1);
        }
        int left = 0, right = 0;
        int count = 0;
        while (right < cc.length) {
            char c = cc[right];
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    count ++;
                }
            }
            while (right - left + 1 == ss.length) {
                if (count == need.size()) {
                    return true;
                }
                char d = cc[left];
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        count --;
                    }
                    window.put(d,window.getOrDefault(d, 0) - 1);
                }
                left ++;
            }

            right++;
        }
        return  false;
    }

}
