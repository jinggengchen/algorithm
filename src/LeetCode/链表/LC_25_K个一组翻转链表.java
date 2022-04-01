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

    }
    //      0        1       2           3           4 5 k=2
    //node/cur      start  end          next
    //     0        2          1          3  4 5
    //   node      end        start/cur      next
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = node;
        // end 先初始化到需要反转区间的前一个位置
        ListNode end = cur;
        while(end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // start 是需要反转区间的头，end是需要反转区间的尾
            // next 是需要反转区间尾部的下一个
            ListNode start = cur.next;
            ListNode next = end.next;

            end.next = null;
            cur.next = reverseList(start);

            start.next = next;

            // 下一次，end应该放到需要反转区间的前一个
            cur = start;
            end = cur;
        }
        return node.next;
    }

    public static ListNode reverseList(ListNode head) {
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
}
