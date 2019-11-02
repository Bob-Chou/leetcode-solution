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
    private double ans;
    public double maximumAverageSubtree(TreeNode root) {
        ans = Double.MIN_VALUE;
        getAvg(root);
        return ans;
    }

    public double[] getAvg(TreeNode root) {
        if (root == null) {
            return new double[] {0.0, 0.0};
        } else {
            double[] leftAvg = getAvg(root.left);
            double[] rightAvg = getAvg(root.right);
            double newAvg = (leftAvg[0] + rightAvg[0] + root.val) / (leftAvg[1] + rightAvg[1] + 1);
            if (newAvg > ans)
                ans = newAvg;
            return new double[] {leftAvg[0] + rightAvg[0] + root.val, leftAvg[1] + rightAvg[1] + 1};
        }
    }
}
