package LeetCode.数组;

import java.util.HashSet;

public class 两个有序数组求交集 {
    // 两个有序数组求交集
    // [1,3,5,7,9]
    // [2,3,5,7,9]
    // 定义两个指针，一个指向数组1的头，一个指向数组2的头
    // 如果等于，i++，j++，结果加到结果集里面
    // 如果i位置 《 j位置 i++
    public static void main(String[] args) {
        int[] a = {-10, -8, -1, 0, 19, 100, 2233};
        int[] b = {0, 198, 2233};
        HashSet<Integer> method = method(a, b);
        System.out.println(method);
    }

    // 两个指针p1,p2 p1指向a数组开头，p2指向b数组开头
    public static HashSet<Integer> method(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        int p1 = 0, p2 = 0;
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                set.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] < b[p2]) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        return set;
    }
}
