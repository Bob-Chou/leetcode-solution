/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    static public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    static public ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail || head == null) return head;
        int length = distance(head, tail);
        head = sortList(head, nodeAt(head, length / 2));
        printLink(head);
        head = sortList(nodeAt(head, length / 2 + 1), tail);
        printLink(head);

        return mergeList(head, nodeAt(head, length / 2).next);
    }
    static private ListNode mergeList(ListNode h1, ListNode t1, ListNode h2, ListNode t2) {

    }

    static private ListNode nodeAt(ListNode head, int step) {
        for (; step > 0 && head != null; --step) {
            head = head.next;
        }
        return head;
    }

    static private int distance(ListNode head, ListNode tail) {
        ListNode p = head;
        int dis = 0;
        while (p != null && p != tail) {
            p = p.next;
            ++dis;
        }
        return dis;
    }

    static private int length(ListNode head) {
        int dis = 0;
        while (head != null) {
            head = head.next;
            ++dis;
        }
        return dis;
    }

    static private void printLink(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print(' ');
            head = head.next;
        }
        System.out.println();
    }
}
