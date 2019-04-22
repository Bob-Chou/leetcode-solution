# Problem 234
## Review log
+ 04/15/2019 Use bi-linked list and hashmap.

## Insight
Could also use java linked hash map.
```java
class LRUCache {
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Integer val = map.get(key);
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
```
