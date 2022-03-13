package LeetCode.排序查找;

import java.util.Arrays;

public class NC_140_冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,8,123,5,1,55,1223,1,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 冒泡排序
    // 两两比较，小的放在前面。
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1 ; i < arr.length ; i++) {
            for (int j = 0 ; j < i; j++) {
                if (arr[i] < arr[j]) {
                    NC_140_快速排序.swap(arr, i, j);
                }
            }
        }
    }
}
