package LeetCode.链表;

public class JZ_18_删除链表的节点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(deleteNode(node1, 3));
    }
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return null;
        }
        ListNode listNode = new ListNode(-1);
        listNode.next = head;

        ListNode cur = listNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return listNode.next;
    }
}
