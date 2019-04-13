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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> tracker = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curLevel = new ArrayList<>();
        TreeNode endNode = root;
        TreeNode rear = root;
        if (root == null) return ans;
        tracker.offer(root);
        while(!tracker.isEmpty()) {
            TreeNode cur = tracker.poll();
            curLevel.add(cur.val);
            if (cur.left != null) {
                tracker.offer(cur.left);
                rear = cur.left;
            }
            if (cur.right != null) {
                tracker.offer(cur.right);
                rear = cur.right;
            }
            if (endNode == cur) {
                ans.add(curLevel);
                curLevel = new ArrayList<>();
                endNode = rear;
            }
        }
        return ans;
    }
}
