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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null)
            subPathSum(ans, new ArrayList<>(), sum, root);

        return ans;
    }

    private void subPathSum(List<List<Integer>> ans, List<Integer> path, int target, TreeNode t) {
        if (t == null)
            return;

        path.add(t.val);
        target -= t.val;

        if (t.left == null && t.right == null && target == 0) {
            ans.add(new ArrayList<>(path));
        }

        if (t.left != null) {
            subPathSum(ans, path, target, t.left);
        }

        if (t.right != null) {
            subPathSum(ans, path, target, t.right);
        }
        path.remove(path.size()-1);
    }
}
