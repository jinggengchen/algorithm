package LeetCode.模拟;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        head.next = tail;
        tail.pre = head;
        lru.set(1,1);
        lru.set(2,2);
        lru.get(1);
        lru.set(3,3);
        lru.get(2);
        lru.set(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);

        while (head.next != null) {
            System.out.println(head.next.value);
            head = head.next;
        }
    }
    // 最近最少使用，当我们get的时候，会把它放在队列的首部
    // 当我们添加元素的时候，也会把它放在队列的首部，如果当前队列长度超过限制，会删除队尾的元素。
    static Map<Integer, Node> map;
    static int capacity = 0;
    static Node head;
    static Node tail;

    class Node {
        int key;
        int value;
        Node next = null;
        Node pre = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
    }
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            // 存在放到队列头部
            moveToHead(map.get(key));
        } else  {
            Node node = new Node(key, value);
            map.put(key, node);
            // 长度超过限制
            if (map.size() > capacity) {
                // 删除队列尾部的元素
                deleteFromTail();
            } else {
                // 长度正常
                insertToHead(node);
            }
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 删除node，重新写入到队列头部
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }

    }

    private void moveToHead(Node node) {
        if (node.pre == head) {
            return;
        } else {
            // 1   2    3
            //   node
            node.pre.next = node.next;
            node.next.pre = node.pre;
            insertToHead(node);
        }
    }

    private void insertToHead(Node node) {
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            return;
        }
        // 1 , 2 , 3
        //   node
        Node next = head.next;
        node.pre = head;
        node.next = next;
        next.pre = node;
        head.next = node;
    }



    private void deleteFromTail() {

        // 1, 2, 3
        map.remove(tail.pre.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }
}
