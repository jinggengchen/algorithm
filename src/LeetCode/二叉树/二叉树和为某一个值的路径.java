package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.Stack;

public class 二叉树和为某一个值的路径 {
    public static void main(String[] args) {

    }
    Stack<TreeNode> stack = new Stack();


    public boolean hasPathSum (TreeNode root, int sum) {
        return dfs(root, sum);
    }
    public boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        stack.push(root);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        stack.pop();
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}
