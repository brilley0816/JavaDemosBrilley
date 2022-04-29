package Brilley.ClassicalAlgorithmsProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brilley
 * @date 2022/4/12
 */
public class LRUCache {
    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {};
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private DLinkedNode head;
    private DLinkedNode tail;
    private int size;
    private void addFirst(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToFirst(DLinkedNode node) {
        remove(node);
        addFirst(node);
    }

    private void remove(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //删除最后一个节点并返回，这里LRU淘汰就是删除的是最后一个结点
    private DLinkedNode removeLast() {
        DLinkedNode ans = tail.pre;
        remove(ans);
        return ans;
    }

    private int getSize() {
        return size;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToFirst(node);
        } else {
            if (capacity == cache.size()) {
                DLinkedNode deletedNode = removeLast();
                cache.remove(deletedNode.key);
                size--;
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            addFirst(newNode);
            cache.put(key, newNode);
            size++;
        }
    }

    public void print() {
        if (head.next == tail) {
            System.out.println("Cache is empty!");
            return;
        }
        DLinkedNode tempNode = head.next;
        while (tempNode != tail) {
            System.out.println("key is: "+tempNode.key + " value is: "+ tempNode.value);
            tempNode = tempNode.next;
        }
    }
}
