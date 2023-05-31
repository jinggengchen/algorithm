package LeetCode.链表;

public class LC_92_从m到n反转链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(123);
        ListNode node2 = new ListNode(412);
        ListNode node3 = new ListNode(213);
        ListNode node4 = new ListNode(992);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseBetween1(node1, 2, 4));
        while(node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
    // 1 -> 2 -> 3 -> 4 -> 5 -> null
    // pre leftnode   rightnode next
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // inv 虚拟节点
        ListNode inv = new ListNode(0);
        inv.next = head;
        ListNode pre = inv;
        // pre 为需要反转的区间的前一个节点
        // cur 为需要反转的区间的后一个节点
        for (int i = 0; i < left - 1; i ++) {
            pre = pre.next;
        }
        // rightNode为需要反转的区间最后一个节点
        // leftNode为需要饭庄的区间的第一个节点
        ListNode rightNode = pre;
        for (int j = 0; j < right - left + 1; j++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        ListNode listNode = reverseList(leftNode);
        pre.next = listNode;
        leftNode.next = cur;
        return inv.next;

    }

    private static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    // 1 2 3 4 5
    // 5>4>3>2<1
    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
    //           2         4
    // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    // 0 -> 1 -> 4 -> 3 -> 2 -> 5 -> null
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        for (int i = 0; i < left - 1; i++) {
            if (node == null) {
                break;
            }
            node = node.next;
        }
        ListNode leftNode = node.next;
        ListNode rightNode = dummy;
        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }
        ListNode end = rightNode.next;
        rightNode.next = null;
        node.next = null;
        ListNode reverse = reverseList(leftNode);
        node.next = reverse;
        leftNode.next = end;
        return dummy.next;
    }
}
