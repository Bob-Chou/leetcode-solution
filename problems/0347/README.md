# Problem 347
## Review log
+ 05/01/2019 AC

## Insight
Use Java's built-in heap `PriorityQueue` to trim out code.
```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        
        if (nums.length <= 1) {
            for (int n: nums) {
                ans.add(n);
            }
            return ans;
        }
        
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue((n1, n2) -> counter.get(n1) - counter.get(n2));
        for (int key : counter.keySet()) {
            if (heap.size() < k) {
                heap.offer(key);
            } else if (counter.get(key) > counter.get(heap.peek())) {
                heap.poll();
                heap.offer(key);
            }
        }
        
        for (int i = 0; i < k; ++i) {
            ans.add(0, heap.poll());
        }
        return ans;
    }
}
```
