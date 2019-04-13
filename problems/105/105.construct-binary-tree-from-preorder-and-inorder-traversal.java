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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int pivot = inStart;
        for (; pivot < inEnd; ++pivot) {
            if (inorder[pivot] == root.val) {
                break;
            }
        }
        root.left = buildSubTree(preorder, preStart+1, preStart+1+pivot-inStart, inorder, inStart, pivot);
        root.right = buildSubTree(preorder, preStart+1+pivot-inStart, preEnd, inorder, pivot+1, inEnd);
        return root;
    }
}
