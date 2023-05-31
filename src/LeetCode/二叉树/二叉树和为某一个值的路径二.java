package LeetCode.二叉树;

import java.util.ArrayList;
import java.util.Stack;

public class 二叉树和为某一个值的路径二 {
    public static void main(String[] args) {

    }
    Stack<TreeNode> stack = new Stack<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)  {
            return res;
        }
        dfs(root, target);
        return res;
    }

    public void dfs (TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        stack.push(root);
        sum -= sum;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList(stack));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        stack.pop();
    }
}
