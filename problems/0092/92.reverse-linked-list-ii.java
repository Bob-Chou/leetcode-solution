/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p, q, l, broken;
        q = p = l = head;
        broken = new ListNode(0);
        broken.next = head;
        head = broken;
        int visited = 0;
        while (visited < n && q != null) {
            ++visited;
            if (visited == m - 1) {
                broken = q;
                q = q.next;
            } else if (visited == m) {
                p = q;
                q = q.next;
            } else if (visited > m) {
                l = q.next;
                q.next = p;
                p = q;
                q = l;
            } else {
                q = q.next;
            }
        }

        l = broken.next;
        broken.next = p;
        l.next = q;

        return head.next;
    }
}
