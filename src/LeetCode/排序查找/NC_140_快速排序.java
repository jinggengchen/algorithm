package LeetCode.排序查找;

import java.util.Arrays;

public class NC_140_快速排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,8,2,4,10,3,2,1};
        System.out.println(Arrays.toString(MySort(arr)));
    }
    public static int[] MySort (int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }



    // 快速排序
    public static void quickSort(int[] arr, int L, int R) {
        if(L >= R) {
            return;
        }
        int mid = partition(arr, L, R);
        quickSort(arr, L, mid - 1);
        quickSort(arr, mid + 1, R);

    }

    public static int partition(int[] arr,int L,int R) {
        // 定义数组的第一个值为参考值
        // 定义一个头指针和一个尾部指针
        // 头指针从左往右，直到遇见比参考元素还大的停止。
        // 尾指针从右往左，直到遇见比参考元素还小的停止。
        // 交换头指针和尾指针的值
        int low = L;
        int fast = R + 1;
        int value = arr[L];
        while (true) {
            // 吧小于参照元素的数放在左边,大于参照元素的数放在右边.
            while (arr[++low] < value) if (low == R) break;
            while (arr[--fast] > value) if (fast == L) break;
            if (low >= fast) {
                break;
            }
            // 交换左右指针
            swap(arr, low, fast);
        }
        System.out.println(Arrays.toString(arr));
        // 最后吧参照元素归位.fast所处的位置的数就是第一个比参照数小的位置
        swap(arr, L , fast);
        return fast;
    }

    public static void swap(int[] arr, int L, int R) {
        int tmp = arr[L];
        arr[L] = arr[R];
        arr[R] = tmp;
    }
}
