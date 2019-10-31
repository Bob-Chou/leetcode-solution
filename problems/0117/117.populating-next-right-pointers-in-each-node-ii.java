/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root != null)
            connectTwoTrees(root.left, root.right);
        return root;
    }
    private void connectTwoTrees(Node left, Node right) {
        if (left == null && left == null) {
            return;
        } else if (left != null && right != null) {
            left.next = right;
            // connect left sub tree
            if (left.left != null) {
                if (left.right != null)
                    connectTwoTrees(left.left, left.right);
                else if (right.left != null)
                    connectTwoTrees(left.left, right.left);
                else
                    connectTwoTrees(left.left, right.right);
            }
            if (left.right != null) {
                if (right.left != null)
                    connectTwoTrees(left.right, right.left);
                else
                    connectTwoTrees(left.right, right.right);
            }
            // connect right sub tree
            if (right.left != null) {
                if (right.right != null)
                    connectTwoTrees(left.left, left.right);
            }
        } else if (left != null) {
            connectTwoTrees(left.left, left.right);
        } else {
            connectTwoTrees(right.left, right.right);
        }
    }
}
