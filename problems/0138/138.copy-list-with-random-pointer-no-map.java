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
        if (head == null)
            return null;
        // link new node to old node's next
        Node prev = head, post;
        while (prev != null) {
            post = prev.next;
            prev.next = new Node(prev.val, prev.next, null);
            prev = post;
        }

        // restore random link
        prev = head;
        while (prev != null) {
            post = prev.next;
            if (prev.random != null)
                post.random = prev.random.next;
            prev = post.next;
        }

        // unravel old link and new link
        prev = head;
        Node dummy = new Node(), p = dummy;
        while (prev != null) {
            p.next = prev.next;
            prev.next = prev.next.next;
            p = p.next;
            prev = prev.next;
        }

        return dummy.next;
    }
}
