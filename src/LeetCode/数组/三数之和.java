package LeetCode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int num[] = {-1,0,1,2,3,4};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(num, 6);
        System.out.println(arrayLists);
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if (num.length < 3) {
            return res;
        }
        Arrays.sort(num);
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int j = i + 1, k = num.length - 1;
            while (j < k) {

                sum = num[i] + num[j] + num[k];
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    res.add(list);
                    while (j < k && num[j] == num[j + 1]) j ++;
                    while (j < k && num[k] == num[k - 1]) k --;
                    j ++;
                    k --;
                } else if (sum < target) {
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return res;
    }
}
