package Brilley.ClassicalAlgorithmsProblems;

import java.util.List;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-01 19:35
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class SortList {
    public static void test() {
        ListNode head = new ListNode(4);
        //ListNode temp = new ListNode(2);
        ListNode tempNode = head;
        int[] arr=new int[]{3, 1, 2};
        //tempNode.next = temp;
        for (int i = 0; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            tempNode.next = temp;
            tempNode = temp;
        }
        tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }

        tempNode = sortList(head);
        System.out.println("After sorting: ");
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }

    }
    private static ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    private static ListNode sortList(ListNode head, ListNode tail) {
        //零、一、二个元素 head有值，tail为null，返回head
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null; //这个很关键，最后把所有的节点都拆成了一个！
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode result = merge(list1, list2);
        return result;
    }
    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode(0);
        ListNode tempNode = tempHead;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                tempNode.next = temp1;
                temp1 = temp1.next;
            } else {
                tempNode.next = temp2;
                temp2 = temp2.next;
            }
            tempNode = tempNode.next;
        }
        if (temp1 != null) {
            tempNode.next = temp1;
        } else if (temp2 != null) {
            tempNode.next = temp2;
        }
        return tempHead.next;
    }

}
