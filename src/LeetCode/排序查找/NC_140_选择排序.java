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
        if (arr.length < 2 || arr == null) {
            return;
        }
        for (int i = 0 ; i < arr.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length ; j ++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NC_140_快速排序.swap(arr, i ,minIndex);
        }
    }
}
