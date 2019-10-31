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
    public int kthSmallest(TreeNode root, int k) {
        Stack<NodeWrapper> visiting = new Stack<>();
        visiting.push(new NodeWrapper(root));
        while (!visiting.empty()) {
            NodeWrapper nodeWithCount = visiting.pop();
            ++nodeWithCount.count;
            if (nodeWithCount.count == 1) {
                visiting.push(nodeWithCount);
                if (nodeWithCount.node.left != null) {
                    visiting.push(new NodeWrapper(nodeWithCount.node.left));
                }
            } else if (nodeWithCount.count == 2) {
                if (--k <= 0)
                    return nodeWithCount.node.val;
                if (nodeWithCount.node.right != null) {
                    visiting.push(new NodeWrapper(nodeWithCount.node.right));
                }
            }
        }
        return -1;
    }
}

class NodeWrapper {
    public TreeNode node;
    public int count;
    public NodeWrapper(TreeNode n) {
        node = n;
        count = 0;
    }
}
