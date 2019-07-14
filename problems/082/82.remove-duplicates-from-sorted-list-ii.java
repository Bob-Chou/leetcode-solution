/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode ans = new ListNode(0), p = head, q = ans;

        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                q.next = p;
                p = p.next;
                q = q.next;
            } else {
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                p = p.next;
            }
        }

        if (p != null) {
            q.next = p;
            q = q.next;
        }
        q.next = null;

        return ans.next;
    }
}
