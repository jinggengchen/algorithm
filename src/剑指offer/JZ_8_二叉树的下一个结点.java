package 剑指offer;

public class JZ_8_二叉树的下一个结点 {
    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node2.next = node1;
        node3.next = node1;
        node5.next = node2;
        node4.next = node2;
        node6.next = node3;
        node7.next = node3;

        System.out.println(GetNext(node4).val);

    }
    static TreeLinkNode head, pre;
    public static TreeLinkNode GetNext(TreeLinkNode p) {
        if (p == null) {
            return null;
        }
        TreeLinkNode root = selectRoot(p);
        dfs(root);
        TreeLinkNode cur = head;
        while (cur != p) {
            cur = cur.right;
        }
        return cur.right;

    }
    public static TreeLinkNode selectRoot(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while(cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    public static void dfs(TreeLinkNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
