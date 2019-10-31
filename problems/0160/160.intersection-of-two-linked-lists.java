/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) return null;
        ListNode a = headA, b = headB;
        while (a.next != null) {
            a = a.next;
        }
        a.next = b;
        ListNode ans = getLoopEntrance(headA);
        a.next = null;
        return ans;
    }

    static private ListNode getLoopEntrance(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next.next, slow = head.next;
        while (fast != slow && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != slow) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
