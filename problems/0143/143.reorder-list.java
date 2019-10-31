/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode p = head, q = head, m, n;

        while (p != null && p.next != null) {
            q = p.next;
            p = p.next.next;
        }

        if (q != null)
            p = p.next;

        m = p;
        n = null;
        while (m != null) {
            p = m;
            m = m.next;
            p.next = n;
            n = p;
        }

        q = head;
        while (p != null) {
            m = q.next;
            q.next = p;
            q = q.next;
            p = m;
        }
    }
}
