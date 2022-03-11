package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class JZ_37_序列化二叉树 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(serialize(node1));
        System.out.println(deserialize("[1,2,3,4,5,6,7,null,null,null,null,null,null,null,null]"));
    }
    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder("[");
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == "[]") {
            return null;
        }
        String[] tree = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!tree[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(tree[i]));
                queue.add(node.left);
            }
            i++;
            if (!tree[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(tree[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
