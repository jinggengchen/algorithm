package LeetCode.链表;

public class JZ_18_删除链表的倒数第n个节点 {
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
        System.out.println(removeNthFromEnd(node1, 3));    }
    // 1 2 3 4 5
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        n = count - n + 1;
        if (n == 1) {
            return head.next;
        }
        count = 0;
        cur = head;
        ListNode pre = null;
        while(cur != null) {
            count++;
            if (count == n) {
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;

    }

}
