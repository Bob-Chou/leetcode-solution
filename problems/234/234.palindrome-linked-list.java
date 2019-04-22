/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode helper = head, right = head, left = null, cache;
        boolean ans = true;

        while (helper != null && helper.next != null) {
            /**
             * Split the link into left one and right one,
             * each step should be taken like
             * before:
             *   1     2 -> 3 -> 2 -> 1
             *   ^     ^    ^
             *  left right helper
             *
             * after:
             *   1 <- 2    3 -> 2 -> 1
             *        ^    ^         ^
             *       left right     helper
             */
            helper = helper.next.next;
            cache = right;
            right = right.next;
            cache.next = left;
            left = cache;
        }
        /**
         * even length:
         * currently points should be like
         *   1 <- 2    2 -> 1 -> null
         *        ^    ^
         *       left right
         *
         * odd length:
         *   1 <- 2    3 -> 2 -> 1 -> null
         *        ^    ^
         *       left right
         */
        // we need to move right forward for a single step if the length is odd
        if (helper != null) right = right.next;
        while (left != null) {
            /**
             * Now we should judge the palindrome and restore the link,
             * each step should be taken like this.
             * before:
             * null <- 1 <- 2     3 -> 3 -> 2 -> 1 -> null
             *              ^     ^         ^
             *            left   helper     right
             *
             * after:
             * null <- 1    2 -> 3 -> 3 -> 2 -> 1 -> null
             *         ^    ^                   ^
             *        left helper               right
             */
            ans &= left.val == right.val;
            cache = left;
            left = left.next;
            cache.next = helper;
            helper = cache;
            right = right.next;
        }
        return ans;
    }
}
