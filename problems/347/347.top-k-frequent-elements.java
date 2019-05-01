class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length <= 1) {
            ans.add(nums[0]);
            return ans;
        }
        minHeap kHeap = new minHeap(k);
        Map<Integer, Integer> helper = new HashMap<>();
        for (int n : nums) {
            if (!helper.containsKey(n)) {
                helper.put(n, 1);
            } else {
                helper.put(n, helper.get(n) + 1);
            }
        }
        for (int key : helper.keySet()) {
            int value = helper.get(key);
            if (kHeap.depth < k) {
                kHeap.push(new int[]{value, key});
            } else {
                if (kHeap.peek()[0] < value) {
                    kHeap.pop();
                    kHeap.push(new int[]{value, key});
                }
            }
        }
        for (int i = 0; i < k; ++i) {
            ans.add(0, kHeap.pop()[1]);
        }
        return ans;
    }
}

class minHeap {
    public int depth;
    private int size;
    private int[][] heap;
    public minHeap(int k) {
        size = k;
        depth = 0;
        heap = new int[size][2];
    }

    private int shuffle(int root) {
        int minIdx = root;

        if (root * 2 + 2 < depth) {
            if (heap[root*2+2][0] < heap[minIdx][0]) {
                minIdx = root * 2 + 2;
            }
        }

        if (root * 2 + 1 < depth) {
            if (heap[root*2+1][0] < heap[minIdx][0]) {
                minIdx = root * 2 + 1;
            }
        }

        if (minIdx != root) {
            int[] tmp = heap[root];
            heap[root] = heap[minIdx];
            heap[minIdx] = tmp;
        }
        return minIdx;
    }

    public void push(int[] node) {
        if (depth < size) {
            heap[depth++] = node;
            int cur = depth - 1;
            do {
                cur = (cur-1)/2;
            } while (shuffle(cur) != cur && cur > 0);
        }
    }

    public int[] pop() {
        int[] ans = heap[0];
        if (depth > 0) {
            heap[0] = heap[depth-- - 1];
            int cur = 0;
            while (cur < depth) {
                int next = shuffle(cur);
                if (next == cur) break;
                cur = next;
            }
        }
        return ans;
    }

    public int[] peek() {
        return heap[0];
    }
}
