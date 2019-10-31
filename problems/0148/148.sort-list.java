/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pivot = head, p = pivot;
        head = head.next;
        ListNode small = new ListNode(0), s  = small;
        ListNode large = new ListNode(0), l = large;
        for (ListNode h = head; h != null; h = h.next) {
            if (h.val < pivot.val) {
                s.next = h;
                s = h;
            } else if (h.val == pivot.val) {
                // ***** This condition branch is very important *****
                // This works well when input contains a large number of
                // indentical numbers and efficiently shrinks time cost
                // in such cases!
                // it shrinks time cost from 600ms to 2ms in leetcode tests
                p.next = h;
                p = h;
            } else {
                l.next = h;
                l = h;
            }
        }
        s.next = l.next = p.next = null;
        head = sortList(small.next);
        if (head == null) {
            head = pivot;
        } else {
            for (s = head; s.next != null; s = s.next);
            s.next = pivot;
        }
        for (p = pivot; p.next != null; p = p.next);
        p.next = sortList(large.next);
        return head;
    }
}
