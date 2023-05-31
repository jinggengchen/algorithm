package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的遍历 {
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList();
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
