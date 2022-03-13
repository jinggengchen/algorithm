package LeetCode.二叉树;

import java.util.ArrayList;

public class JZ_32_从上到下打印二叉树_I {
    ArrayList<ArrayList<Integer>> ans = new ArrayList();
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        dfs(root, 0);
        int[] res = new int[ans.size()];
        int index = 0;
        for(int i = 0; i < ans.size(); i++) {

            for (int j = 0; j < ans.get(i).size(); j++) {
                res[index++] =  ans.get(i).get(j);
            }
        }
        return res;
    }
    void dfs(TreeNode root, int denth) {
        if (root == null) {
            return;
        }
        if (ans.size() <= denth) {
            ans.add(new ArrayList());
        }
        ans.get(denth).add(root.val);
        dfs(root.left, denth + 1);
        dfs(root.right, denth +1);
    }
}
