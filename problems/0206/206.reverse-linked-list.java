/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, q = head.next;
        p.next = null;
        while (q != null) {
            head = q;
            q = q.next;
            head.next = p;
            p = head;
        }
        return head;
    }
}
