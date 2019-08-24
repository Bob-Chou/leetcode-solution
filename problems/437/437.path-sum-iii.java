/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumAdjacent(root, sum) + pathSumAdjacent(root.left, sum) + pathSumAdjacent(root.right, sum);
    }

    private int pathSumAdjacent(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
            + pathSumAdjacent(node.left, sum - node.val) + pathSumAdjacent(node.right, sum - node.val);
    }
}
