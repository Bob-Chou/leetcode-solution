/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode p = head, p1 = less, p2 = greater;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p = p.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = p;
                p = p.next;
                p2 = p2.next;
                p2.next = null;
            }
        }
        p1.next = greater.next;
        p1 = less.next;
        less.next = null;
        greater.next = null;
        return p1;
    }
}
