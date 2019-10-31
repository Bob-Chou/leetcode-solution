/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode h, p, q;
            h = new ListNode(-1);
            h.next = head;
            p = h.next;
            q = p.next;
            head = h;
            while (q != null) {
                p.next = q.next;
                h.next = q;
                q.next = p;
                if (p.next == null) break;
                h = p;
                p = p.next;
                q = p.next;
            }
            head = head.next;
        }
        return head;
    }
}
