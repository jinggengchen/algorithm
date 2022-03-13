package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class LC_159_至多包含两个不同字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("abcbb"));
    }
    public static int lengthOfLongestSubstringKDistinct(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < chars.length) {
            char c = chars[right];
            map.put(c,map.getOrDefault(c, 0) +1);
            if (map.size() > 2) {
                char d =chars[left];
                if (map.get(d) == 1) {
                    map.remove(d);
                } else {
                    map.put(d, map.getOrDefault(d,0) - 1);
                }
                left ++;
            }
            res = Math.max(res, right - left +1);
            right ++;
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {
        // key 表示当前的字符
        // value 表示当前字符出现的位置
        char[] ss = s.toCharArray();
        int res = 0;
        Map<Character, Integer> map = new HashMap();

        for (int i = 0, j = 0; j < ss.length;j ++) {
            if (map.containsKey(ss[j])) {
                i = Math.max(i,map.get(ss[j]));
            }
            res = Math.max(res, j - i + 1);
            map.put(ss[j],j + 1);
        }
        return res;

    }
}
