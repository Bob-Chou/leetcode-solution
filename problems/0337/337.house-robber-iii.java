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
    static public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] ans = robTree(root);
        return ans[0] > ans[1] ? ans[0] : ans[1];
    }

    static private int[] robTree(TreeNode root) {
        int[] maxRoot = new int[2];
        if (root == null) return maxRoot;
        int[] maxLeft = robTree(root.left);
        int[] maxRight = robTree(root.right);
        maxRoot[0] = (maxLeft[0] > maxLeft[1] ? maxLeft[0] : maxLeft[1]) + (maxRight[0] > maxRight[1] ? maxRight[0] : maxRight[1]);
        maxRoot[1] = root.val + maxLeft[0] + maxRight[0];
        return maxRoot;
    }
}
