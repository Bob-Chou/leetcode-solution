class BiLinkedList {
    public BiLinkedList prev;
    public BiLinkedList next;
    public int key;
    public int value;

    public BiLinkedList(int k, int x) {
        key = k;
        value = x;
    }

    public void linkAfter(BiLinkedList prevNode) {
        if (prevNode != null) prevNode.next = this;
        prev = prevNode;
    }

    public void linkBefore(BiLinkedList nextNode) {
        if (nextNode != null) nextNode.prev = this;
        next = nextNode;
    }

    public void dropFromLink() {
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, BiLinkedList> cache;
    private int capacity, volumn;
    private BiLinkedList head, rear;
    public LRUCache(int c) {
        capacity = c;
        volumn = 0;
        head = new BiLinkedList(-1, -1); // placeholder
        rear = head;
        cache = new HashMap<>();
    }

    private void update(BiLinkedList node) {
        if (node != null && node != rear) {
            node.dropFromLink();
            node.linkAfter(rear);
            rear = node;
        }
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            BiLinkedList rtn = cache.get(key);
            update(rtn);
            return rtn.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // if key already exists
        if (cache.containsKey(key)) {
            BiLinkedList rtn = cache.get(key);
            rtn.value = value;
            update(rtn);
            return;
        }
        // add new Node
        rear.linkBefore(new BiLinkedList(key, value));
        cache.put(key, rear.next);
        rear = rear.next;
        // if exceeds capacity
        if (++volumn > capacity) {
            cache.remove(head.next.key);
            head.next.dropFromLink();
            --volumn;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
