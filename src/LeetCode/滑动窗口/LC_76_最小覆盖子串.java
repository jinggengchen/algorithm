package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class LC_76_最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow ("bbaa", "aba"));
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int len = Integer.MAX_VALUE;
        for (char c : tt) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        int count = 0;
        int left = 0, right = 0;
        int start = 0, end = 0;
        while (right < ss.length) {
            //右移动窗口
            char c = ss[right];
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    count ++;
                }
            }
            right ++;
            while (count == need.size()) {
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
                char b = ss[left];
                if (need.containsKey(b)) {
                    if (need.get(b).equals(window.get(b))) {
                        count --;
                    }
                    window.put(b, window.getOrDefault(b,0) - 1);
                }
                left ++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
