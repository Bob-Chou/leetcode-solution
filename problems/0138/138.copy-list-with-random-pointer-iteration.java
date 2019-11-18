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
        HashMap<Node, Node> mapper = new HashMap<>();
        Node p = head;
        Node dummy = new Node(), q = dummy;

        while (p != null) {
            q.next = new Node();
            q = q.next;
            q.val = p.val;
            mapper.put(p, q);
            p = p.next;
        }

        p = head;
        q = dummy.next;

        while (p != null) {
            q.random = mapper.get(p.random);
            q = q.next;
            p = p.next;
        }

        return dummy.next;
    }
}
