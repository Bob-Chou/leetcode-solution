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
    private int ans;
    public Solution() {
        this.ans = Integer.MIN_VALUE;
    }
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        int maxSum = this.ans;
        this.ans = Integer.MIN_VALUE;
        return maxSum;
    }
    private int maxPathSumHelper(TreeNode root) {

        if (root == null)
            return 0;

        int rightChildSum = maxPathSumHelper(root.left);
        int LeftChildSum = maxPathSumHelper(root.right);
        int rtn = 0;

        if (root.val + rightChildSum > rtn)
            rtn = root.val + rightChildSum;

        if (root.val + LeftChildSum > rtn)
            rtn = root.val + LeftChildSum;

        if (rightChildSum + LeftChildSum + root.val > this.ans)
            this.ans = rightChildSum + LeftChildSum + root.val;

        return rtn;
    }
}
