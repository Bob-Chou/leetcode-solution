class Solution {
    public int findKthLargest(int[] nums, int k) {
        minHeap helper = new minHeap(k);
        for (int i = 0; i < k; ++i) {
            helper.insert(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            if (helper.peek() <= nums[i]) {
                helper.removeTop();
                helper.insert(nums[i]);
            }

        }
        return helper.peek();
    }
}

/**
*            0
*          /   \
*         1     2
*        / \   / \
*       3   4 5   6
*/
class minHeap {
    private int rear;
    private int capacity;
    private int[] heap;
    public minHeap(int c) {
        capacity = c;
        rear = -1;
        heap = new int[c];
    }
    public int peek() {
        if (rear >= 0) return heap[0];
        else throw new ArrayIndexOutOfBoundsException("Empty Heap");
    }
    public void shuffle(int start) {
        if (start > rear || start < 0) return;
        while (2 * start < rear) {
            int minIdx = start;
            minIdx = heap[minIdx] > heap[2*start+1] ? 2*start+1 : minIdx;
            if (2*start+1 < rear) minIdx = heap[minIdx] > heap[2*start+2] ? 2*start+2 : minIdx;
            if (minIdx == start) return;
            int tmp = heap[minIdx];
            heap[minIdx] = heap[start];
            heap[start] = tmp;
            start = minIdx;
        }
    }
    public void insert(int v) {
        if (rear + 1 >= capacity) throw new ArrayIndexOutOfBoundsException("Heap is full");
        heap[++rear] = v;
        for (int i = (rear+1)/2-1; i >= 0; i = (i+1)/2-1) shuffle(i);
    }
    public void removeTop() {
        heap[0] = heap[rear];
        rear -= 1;
        shuffle(0);
    }
    public boolean isEmpty() {
        return rear >= 0;
    }
}
