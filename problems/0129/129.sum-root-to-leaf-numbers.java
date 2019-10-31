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
    public int sumNumbers(TreeNode root) {
        return sumDownstream(root, 0);
    }

    public int sumDownstream(TreeNode root, int upstream) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return upstream*10 + root.val;

        int ans = 0;
        if (root.left != null) {
            ans += sumDownstream(root.left, 10*upstream+root.val);
        }
        if (root.right != null) {
            ans += sumDownstream(root.right, 10*upstream+root.val);
        }
        return ans;
    }
}
