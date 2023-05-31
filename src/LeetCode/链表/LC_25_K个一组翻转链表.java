package LeetCode.链表;

public class LC_25_K个一组翻转链表 {
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
        System.out.println(reverseKGroup(node1, 2));
        while(node2 != null) {
            System.out.println(node2.val);
            node2 = node2.next;
        }

    }

    // 1 -> 2 -> 3 -> 4 -> 5
    // newHead
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        for (int i = 0; i < k ; i ++) {
            if (newHead == null) {
                return head;
            }
            newHead = newHead.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != newHead) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroup(newHead,k);
        return pre;
    }
}
