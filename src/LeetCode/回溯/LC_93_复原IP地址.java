package LeetCode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */

/**
 * 限制条件：
 * 1。四个整数
 * 2。每一个整数范围是0-255，不能包含前导0。02，03这种就是前导0
 * 3。每一个整数长度是1-3
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
        dfs1(0, s, new ArrayList<String>());
        return res;
    }

    // start 表示dfs搜索的起始位置
    // s是字符串
    // list是存储结果的集合
    private static void dfs1(int start, String s, ArrayList<String> list) {
        // 当什么时候跳出dfs
        // 指针指向s末尾
        // list里面有4个整数
        if (start == s.length() && list.size() == 4) {
            res.add(String.join("." , list));
        }
        for (int i = 1; i <= 3; i++) {
            // 截取字符串不能超过s的长度
            if (start + i > s.length()) {
                break;
            }
            String str = s.substring(start, start + i);
            if ((str.startsWith("0") && str.length() > 1) || (i == 3 && Integer.parseInt(str) > 255)) {
                continue;
            }
            list.add(str);
            dfs1(start + i, s, list);
            list.remove(list.size() - 1);
        }
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
