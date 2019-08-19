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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        helper.offer(root);
        List<Integer> ans = new ArrayList<>();
        int layerNum = 1;
        while (!helper.isEmpty()) {
            TreeNode node = null;
            int nextLayerNum = 0;
            while (--layerNum >= 0) {
                node = helper.poll();
                if (node.left != null) {
                    helper.offer(node.left);
                    ++nextLayerNum;
                }
                if (node.right != null) {
                    helper.offer(node.right);
                    ++nextLayerNum;
                }
            }
            layerNum = nextLayerNum;
            ans.add(node.val);
        }
        return ans;
    }
}

