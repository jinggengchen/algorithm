package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class LC_76_最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow1 ("PPADOBECODEBANC", "ABC"));
    }

    // P P A D O B E C O D E B A N C
    // A B C

    // need: {A:1,B:1,C:1}
    // P P A D O B E C
    // {A:1,B:1,C:1}


    public static String minWindow1(String s, String t) {
        int left = 0, right = 0;
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int len = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        int end = 0;
        for (Character chars: tt) {
            need.put(chars, need.getOrDefault(chars, 0) + 1);
        }
        while (right < ss.length) {
            char s1 = ss[right];
            right ++;
            // TODO
            if (need.containsKey(s1)) {
                windows.put(s1, windows.getOrDefault(s1, 0) + 1);
                if (windows.get(s1).equals(need.get(s1))) {
                    count ++;
                }
            }

            //
            while (count == need.size()) {
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
                char s2 = ss[left];
                left ++;
                if (need.containsKey(s2)) {
                    if (need.get(s2).equals(windows.get(s2))) {
                        count --;
                    }
                    windows.put(s2, windows.getOrDefault(s2, 0) - 1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
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
