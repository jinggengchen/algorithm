package 牛客;

public class NC_105_Search {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(search(nums, 7));
    }
    public static int search (int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return nums[R] == target ? R : -1;
    }
}
