package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_589_N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            if (cur.children != null) {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return res;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}