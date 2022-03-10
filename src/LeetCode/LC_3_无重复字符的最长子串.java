package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC_3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0, j = 0; j < c.length; j ++) {
            if (map.containsKey(c[j])) {
                i = Math.max(i, map.get(c[j]));
            }
            res = Math.max(res, j - i + 1);
            map.put(c[j], j + 1);

        }
        return res;
    }
}
