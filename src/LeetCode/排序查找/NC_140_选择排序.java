package LeetCode.排序查找;

import java.util.Arrays;

public class NC_140_选择排序 {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,8,123,5,1,55,1223,1,2,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    // 选择排序
    // 在0 - n上面找最小的放在第一个
    // 在1 - n上面找最小的放在第二个
    // 在2 - n上面找最小的放在第三个
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // minIndex 是最小的位置，假设初始时最小位置是0
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int L, int R) {
        int tmp = arr[L];
        arr[L] = arr[R];
        arr[R] = tmp;
    }
}
