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
        int listLength = 0;
        for (ListNode p = head; p != null; p = p.next)
            ++listLength;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int sortLength = 1; sortLength < listLength; sortLength <<= 1) {
            ListNode breakPoint = dummy, left, right, next;
            do {
                left = breakPoint.next;
                right = splitList(left, sortLength);
                next = splitList(right, sortLength);
                breakPoint = mergeList(left, right, breakPoint);
                breakPoint.next = next;
            } while (breakPoint != null && breakPoint.next != null);
        }
        return dummy.next;
    }
    private ListNode mergeList(ListNode left, ListNode right, ListNode head) {
        if (head == null)
            return null;
        ListNode l = left, r = right, cur = head;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null)
            cur.next = l;
        if (r != null)
            cur.next = r;
        while (cur.next != null)
            cur = cur.next;
        return cur;
    }
    private ListNode splitList(ListNode left, int breakLength) {
        if (left == null)
            return null;

        ListNode p = left;
        for (int i = 0; i < breakLength - 1 && p.next != null; ++i) {
            p = p.next;
        }
        ListNode q = p.next;
        p.next = null;
        return q;
    }
    private void print(ListNode p) {
        for (ListNode tmp = p; tmp != null; tmp = tmp.next)
            System.out.println(tmp.val);
        System.out.println('$');
    }
}
