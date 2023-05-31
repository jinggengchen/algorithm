package LeetCode.字符串;

import java.util.Arrays;
import java.util.Comparator;

import static LeetCode.排序查找.NC_140_快速排序.swap;

//给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
// 输入
//[30,1，55]
//输出
//"301"
public class 组成数组的最大值 {
    public static void main(String[] args) {
        int[] nums = {390, 221, 90, 10, 4};
        String solve = solve(nums);
        System.out.println(solve);
    }

    public static String solve(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));
        StringBuilder maxString = new StringBuilder();

        for (int i = 0; i < strArr.length; i++) {
            maxString.append(strArr[i]);
        }
        return maxString.toString();
    }

}
