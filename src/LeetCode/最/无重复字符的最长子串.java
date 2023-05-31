package LeetCode.最;

import java.util.HashMap;
import java.util.HashSet;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(method("abcderfff"));
    }
    // i j
    public static int method(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                i = Math.max(i, map.get(arr[j]));
            }
            res = Math.max(res, j - i + 1);
            map.put(arr[j], j + 1);
        }
        return res;
    }
}
