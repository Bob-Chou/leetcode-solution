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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        trackNodePath(root, p, pStack);
        trackNodePath(root, q, qStack);
        while (pStack.size() > qStack.size()) {
            pStack.pop();
        }
        while (qStack.size() > pStack.size()) {
            qStack.pop();
        }
        while (qStack.size() > 0) {
            if (qStack.peek() == pStack.peek()) return qStack.pop();
            qStack.pop();
            pStack.pop();
        }
        return null;
    }

    static private boolean trackNodePath(TreeNode root, TreeNode p, Stack<TreeNode> path) {
        if (root == null) return false;
        path.push(root);
        if (root == p) return true;
        boolean ans = false;
        if (root.left != null) ans |= trackNodePath(root.left, p, path);
        if (root.right != null && !ans) ans |= trackNodePath(root.right, p, path);
        if (ans) return true;
        path.pop();
        return false;
    }
}
