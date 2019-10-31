
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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int height = getHeight(root);
        int rightHeight = getHeight(root.right);
        if(rightHeight + 1 == height) {
            return (1 << (height - 1)) + countNodes(root.right);
        } else {
            return (1 << (height - 2)) + countNodes(root.left);
        }
    }
    private int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + getHeight(root.left);
    }
}
