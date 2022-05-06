package Brilley.ClassicalAlgorithmsProblems;

import java.util.List;

/**
 * @author Brilley
 * @date 2022/4/29
 */
public class RemoveNthFromEnd {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val; }
        ListNode(int val, ListNode next) {this.val =val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virHead = new ListNode(0,head);
        ListNode fast = virHead;
        ListNode slow = virHead;
        int i = n;
        while (i != 0) {
            fast = fast.next;
            i--;
            if (fast == null) {
                if (i != 0)
                    return virHead.next;
                else
                    break;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virHead.next;
    }
}
