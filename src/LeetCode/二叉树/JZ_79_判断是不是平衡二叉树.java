package LeetCode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class JZ_79_判断是不是平衡二叉树 {
    public static void main(String[] args) {

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(denth(root.left) - denth(root.right)) <= 1;
    }
    public int denth(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(cur);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count ++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return count;
    }
}
