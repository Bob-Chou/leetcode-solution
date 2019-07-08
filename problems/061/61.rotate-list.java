/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;

        // cnt the length
        int length = 1;
        while (p1.next != null) {
            ++length;
            p1 = p1.next;
        }

        // move p2 to the right
        for (int i = 0; i < k % length; ++i) {
            p2 = p2.next;
        }

        p1 = head;
        while (p2.next != null) {
            p1 =p1.next;
            p2 = p2.next;
        }

        p2.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }
}
