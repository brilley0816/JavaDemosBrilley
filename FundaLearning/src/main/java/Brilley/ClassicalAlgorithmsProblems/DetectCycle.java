package Brilley.ClassicalAlgorithmsProblems;

/**
 * @author Brilley
 * @date 2022/4/29
 */
public class DetectCycle {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val; }
        ListNode(int val, ListNode next) {this.val =val; this.next = next; }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    fast = head;
                    while (fast != slow) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            else break;
        }
        return null;
    }
}
