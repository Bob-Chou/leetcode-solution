/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null)
            return null;

        ListNode fast = head, slow = head;
        int listLength = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            listLength += 2;
        }
        if (fast != null)
            listLength += 1;

        TreeNode ans = new TreeNode(slow.val);
        buildBST(ans, head, listLength/2, slow.next, listLength-listLength/2-1);
        return ans;
    }

    private void buildBST(TreeNode root, ListNode leftList, int leftLength,  ListNode rightList, int rightLength) {

        if (root == null || leftList == null && rightList == null)
            return;

        ListNode p = leftList, q = rightList;

        for (int i = leftLength / 2; i > 0; --i) {
            p = p.next;
        }

        for (int i = rightLength / 2; i > 0; --i) {
            q = q.next;
        }

        if (leftLength > 0) {
            root.left = new TreeNode(p.val);
            p = p.next;
        }

        if (rightLength > 0) {
            root.right = new TreeNode(q.val);
            q = q.next;
        }

        if (leftLength > 1)
            buildBST(root.left, leftList, leftLength/2, p, leftLength-leftLength/2-1);

        if (rightLength > 1)
            buildBST(root.right, rightList, rightLength/2, q, rightLength-rightLength/2-1);
    }
}
