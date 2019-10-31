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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> rtn = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {
                rtn.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    rtn.add(cur.val);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return rtn;
    }
}
