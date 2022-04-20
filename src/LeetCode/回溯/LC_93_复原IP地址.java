package LeetCode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class LC_93_复原IP地址 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return res;
        }
        dfs(0, s, new ArrayList<String>());
        return res;
    }

    // start 表示当前处于s中的位置
    // s 表示原始字符串
    // list 表示当前满足要求的集合
    private static void dfs(int start, String s, ArrayList<String> list) {
        // 什么时候跳出循环：当前集合长度是4，并且start位置处于s最右端
        // 什么时候跳出循环：当前集合长度是4，s已经遍历完了。
        if (list.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", list));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                break;
            }
            String segment = s.substring(start, start + i);
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            list.add(segment);
            dfs(start + i, s, list);
            list.remove(list.size() - 1);
        }

    }
}
