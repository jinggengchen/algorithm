package LeetCode.数组;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class 两个有序数组合并 {
    public static void main(String[] args) {
        int a = 2, b = 3;
        func(a, b);
        System.out.println(a);
        System.out.println(b);
    }
    public static void func(int a, int b) {
        a = a + a;
        b = b + b;
        System.out.println(a);
        System.out.println(b);
    }

    public static List<Integer> method(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[a.length + b.length];

        int p1 = 0, p2 = 0;
        while (p1 < a.length && p2 < b.length) {
            if (a[p1] < b[p2]) {
                list.add(a[p1]);
                p1++;
            } else {
                list.add(b[p2]);
                p2++;
            }
        }
        return list;
    }
}
