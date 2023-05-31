package LeetCode.数组;

import java.util.HashMap;

public class 数组中超过一半的元素 {
    public static void main(String[] args) {
        int arr[] = {1,2,2,2,2,2};
        int more = more(arr);
        System.out.println(more);
    }
    public static int more(int[] array) {
        int n = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        for (int i = 0; i < map.size(); i++) {
            if (map.get(array[i]) > n/2) {
                return array[i];
            }
        }
        return -1;
    }
}
