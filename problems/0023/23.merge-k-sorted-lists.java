/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Pair<Integer, ListNode>> nexts = new PriorityQueue<>(new Comparator<Pair<Integer, ListNode>> () {
            public int compare(Pair<Integer, ListNode> a, Pair<Integer, ListNode> b) {
                ListNode n1 = a.getValue();
                ListNode n2 = b.getValue();
                if (n1 == null && n2 == null)
                    return 0;
                if (n1 == null)
                    return 1;
                if (n2 == null)
                    return -1;
                return n1.val - n2.val;
            }
        });
        ListNode dummy = new ListNode(-1), p = dummy;

        for (int i = 0; i < lists.length; ++i) {
            ListNode node = lists[i];
            nexts.offer(new Pair<Integer, ListNode>(i, node));
            if (node != null)
                lists[i] = node.next;
        }


        while (!nexts.isEmpty()) {
            Pair<Integer, ListNode> nodePair = nexts.poll();
            ListNode node = nodePair.getValue();
            p.next = node;
            p = p.next;
            if (node != null) {
                nodePair.setValue(node.next);
                nexts.offer(nodePair);
            } else {
                break;
            }
        }

        return dummy.next;
    }

    static final class Pair<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() { return key; }
        @Override
        public V getValue() { return value; }
        @Override
        public V setValue(V newValue) {
            V old = value;
            value = newValue;
            return newValue;
        }
    }
}
