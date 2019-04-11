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
        Stack<TreeNode> helper = new Stack<>();
        Map<TreeNode, Integer> counter = new HashMap<>();
        List<Integer> rtn = new ArrayList<>();
        if (root == null) return rtn;
        helper.push(root);
        counter.put(root, 0);
        while(!helper.empty()) {
            TreeNode top = helper.peek();
            if (counter.get(top) == 0) {
                counter.put(top, 1);
                if (top.left != null) {
                    helper.push(top.left);
                    counter.put(top.left, 0);
                }
            } else {
                rtn.add(top.val);
                helper.pop();
                if (top.right != null) {
                    helper.push(top.right);
                    counter.put(top.right, 0);
                }
            }
        }
        return rtn;
    }
}
