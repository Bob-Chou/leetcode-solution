/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode h = new ListNode(-1);
        ListNode p = h;
        while (n1 != null && n2 != null) {
                if (n1.val < n2.val)  {
                    p.next = n1;
                    n1 = n1.next;
                    p = p.next;
                } else {
                    p.next = n2;
                    n2 = n2.next;
                    p = p.next;
                }
            }

        if (n1 != null) {
            p.next = n1;
        } else {
            p.next = n2;
        }

        return h.next;
    }
}
