class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        /**
         * **MUST** use `compareTo` instead of n2 - n1 to avoid overflow case
         * e.g. n2 = Integer.MIN_VALUE, n1 = 1;
         *      n2 - n1 < Integer.MIN_VALUE and so go positive number incorrectly
         */
        maxHeap = new PriorityQueue<>((n1, n2) -> n2.compareTo(n1));
        minHeap.offer(Integer.MAX_VALUE);
        maxHeap.offer(Integer.MIN_VALUE);
    }

    public void addNum(int num) {
        if (maxHeap.size() <= minHeap.size()) {
            if (num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return new Double(maxHeap.peek());
        } else {
            return (new Double(minHeap.peek()) + new Double(maxHeap.peek())) / 2.0;
        }
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
