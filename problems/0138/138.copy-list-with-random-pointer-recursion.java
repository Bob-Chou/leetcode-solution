/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mapper = new HashMap<>();
        return subCopyRandomList(head, new HashMap<>());
    }

    public Node subCopyRandomList(Node head, HashMap<Node, Node> mapper) {
        if (head == null)
            return null;
        Node rtn = mapper.getOrDefault(head, new Node(head.val, null, null));
        mapper.putIfAbsent(head, rtn);
        if (head.random != null) {
            rtn.random = mapper.getOrDefault(head.random, new Node(head.random.val, null, null));
            mapper.putIfAbsent(head.random, rtn.random);
        }

        if (head.next != null)
            rtn.next = subCopyRandomList(head.next, mapper);
        return rtn;
    }
}
