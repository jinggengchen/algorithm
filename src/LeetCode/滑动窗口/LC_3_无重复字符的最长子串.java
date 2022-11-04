package LeetCode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class LC_3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }



    public static int lengthOfLongestSubstring2(String s) {
        // 当前字符出现的次数
        Map<Character, Integer> windons = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        while(right < s.length()) {
            char a = chars[right];
            windons.put(a, windons.getOrDefault(a, 0) + 1);
            right ++;
            // 当前字符出现了多次，就需要缩小窗口范围
            while (windons.get(a) > 1) {
                char b = chars[left];
                windons.put(b, windons.getOrDefault(b,0) - 1);
                left ++;
            }
            res = Math.max(res, right - left);
        }
        return res;

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

    public static int lengthOfLongestSubstring1(String s) {


        Map<Character, Integer> windows = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c = chars[right];
            right ++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            System.out.println("window: [" + left + "," + right + ")");
            // 判断左侧窗口是否要收缩
            while (windows.get(c) > 1) {
                // d 是将移出窗口的字符
                char d = chars[left];
                // 缩小窗口
                left++;
                windows.put(d, windows.getOrDefault(d, 0) - 1);
                // 进行窗口内数据的一系列更新
            }
            res = Math.max(res, right - left);

        }
        return res;
    }
}
