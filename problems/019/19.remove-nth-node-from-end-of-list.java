/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        for (int i=0; i < n; ++i) {
            right = right.next;
        }

        if (right == null) {
            head = head.next;
            return head;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return head;
    }
}
