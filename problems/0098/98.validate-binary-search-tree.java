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
    public boolean isValidBST(TreeNode root) {
        boolean valid = true;
        boolean isFirstNode = true;
        int trace = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (isFirstNode) {
                    isFirstNode = false;
                } else if (cur.val <= trace) {
                    valid &= false;
                }
                trace = cur.val;
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == cur) {
                    prev.right = null;
                    if (isFirstNode) {
                        isFirstNode = false;
                    } else if (cur.val <= trace) {
                        valid &= false;
                    }
                    trace = cur.val;
                    cur = cur.right;
                } else {
                    prev.right = cur;
                    cur = cur.left;
                }
            }
        }
        return valid;
    }
}
