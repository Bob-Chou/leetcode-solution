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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length);
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
        if (start >= end)
            return null;

        TreeNode root;
        int mid = (start + end) / 2;
        root = new TreeNode(nums[mid]);

        if (mid + 1 < end) {
            root.right = constructBST(nums, mid + 1, end);
        }

        if (start < mid) {
            root.left = constructBST(nums, start, mid);
        }

        return root;
    }
}
