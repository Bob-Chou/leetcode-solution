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
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode tmp = reverseList(head.next), p = tmp;
            while (p.next != null) p = p.next;
            p.next = head;
            head.next = null;
            return tmp;
        }
    }
}
