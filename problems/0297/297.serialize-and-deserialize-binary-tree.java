/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private class NodeRef {
        public TreeNode node;
        public int count;
        public NodeRef(TreeNode n) {
            node = n;
            count = 0;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ser = new StringBuilder();
        Queue<TreeNode> buffer = new LinkedList<>();
        if (root == null)
            return "";

        buffer.offer(root);
        while (!buffer.isEmpty()) {
            TreeNode node = buffer.poll();
            if (node != null) {
                ser.append(String.valueOf(node.val));
                buffer.offer(node.left);
                buffer.offer(node.right);
            }
            ser.append(",");
        }
        return ser.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        System.out.println(nodes.length);
        if (nodes.length < 1 || nodes[0].length() == 0)
            return null;

        Queue<NodeRef> buffer = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        buffer.offer(new NodeRef(root));
        for (int i = 1; i < nodes.length; ++i) {
            NodeRef nodeRef = buffer.peek();

            if (++nodeRef.count == 2)
                buffer.poll();

            if (nodes[i].length() != 0) {
                TreeNode cur = new TreeNode(Integer.parseInt(nodes[i]));
                if (nodeRef.count == 1)
                    nodeRef.node.left = cur;
                else
                    nodeRef.node.right = cur;
                buffer.offer(new NodeRef(cur));
            }
        }
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
