/**
 *  find ai, aj. |ai-aj| <= t and |i-j| <= k
 */
class TreeNode {
    long val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int n) {
        val = (long) n;
    }
}
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums.length < 2 || k < 1 || t < 0)
            return false;

        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; ++i)
            nodes[i] = new TreeNode(nums[i]);

        TreeNode head = nodes[0];
        for (int i = 1; i < nums.length; ++i) {
            if (i - k > 0)
                head = delete(head, nodes[i-k-1]);
            if (insert(head, nodes[i]) <= t)
                return true;
        }

        return false;
    }

    private long insert(TreeNode head, TreeNode node) {
        long minGap = Long.MAX_VALUE;

        if (head == null || node == null || head == node)
            return minGap;

        TreeNode cur = head;
        while (cur != node) {
            minGap = Math.min(minGap, Math.abs(cur.val - node.val));
            if (cur.val <= node.val) {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }

            }
        }
        return minGap;
    }
    private TreeNode delete(TreeNode head, TreeNode node) {
        if (head == null || node == null)
            return head;

        TreeNode dummy = new TreeNode(0), prev = dummy, cur = head;
        dummy.left = head;
        while (cur != null && cur != node) {
            prev = cur;
            if (cur.val <= node.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (cur == node) {
            TreeNode p = cur, sub = cur;
            // find the substitute node for current node.
            // substitute node should be :
            // either the rightmost node of left subtree
            // or the leftmost node of right subtree
            if (cur.left != null) {
                // get the rightmost node of left subtree
                sub = cur.left;
                while (sub.right != null) {
                    p = sub;
                    sub = sub.right;
                }
                // maintain the original structure
                replace(p, sub, sub.left);
            } else if (cur.right != null) {
                // get the leftmost node of left subtree
                sub = cur.right;
                while (sub.left != null) {
                    p = sub;
                    sub = sub.left;
                }
                // maintain the original structure
                replace(p, sub, sub.right);
            }
            sub.left = cur.left;
            sub.right = cur.right;
            replace(prev, cur, sub);
        }
        return dummy.left;
    }

    private void replace(TreeNode prev, TreeNode cur, TreeNode sub) {
        if (prev.left == cur)
            prev.left = sub;
        else if (prev.right == cur)
            prev.right = sub;
    }
}
