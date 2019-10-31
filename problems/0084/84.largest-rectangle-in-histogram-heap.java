class Solution {
    public int largestRectangleArea(int[] heights) {
        int[][] heap = new int[heights.length][2];
        for (int i = 0; i < heights.length; ++i) {
            heap[i] = new int[] {heights[i], i};
        }
        helperHeap helper = new helperHeap(heap);
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left <= right && !helper.isEmpty()) {
            int[] top = helper.getTop();
            while (!helper.isEmpty() && (top[1] < left || top[1] > right)) {
                helper.pop();
                top = helper.getTop();
            }
            if (helper.isEmpty()) break;

            if (top[0] * (right - left + 1) > max) {
                max = top[0] * (right - left + 1);
            }
            if (heights[left] < heights[right]) ++left;
            else --right;
        }

        return max;
    }
}

class helperHeap {

    private int end;
    private int[][] value;

    public helperHeap(int[][] arr) {
        value = arr;
        end = value.length - 1;
        for (int i = (end + 1) / 2 - 1; i >= 0; --i) {
            shuffleHeap(value, i);
        }
    }

    private void shuffleHeap(int[][] heap, int top) {
        if (top < 0 || 2 * top + 1 > end) {
            return;
        }
        int minIndex = top;
        if (heap[minIndex][0] > heap[2*top+1][0]) {
            minIndex = 2*top+1;
        }
        if (2 * top + 2 <= end && heap[minIndex][0] > heap[2*top+2][0]) {
            minIndex = 2*top+2;
        }
        if (minIndex == top) return;
        int[] tmp = heap[minIndex];
        heap[minIndex] = heap[top];
        heap[top] = tmp;
        shuffleHeap(heap, minIndex);
    }

    public void pop() {
        if (!isEmpty()) {
            value[0] = value[end];
            --end;
            shuffleHeap(value, 0);
        }
    }

    public int[] getTop() {
        return value[0];
    }

    public boolean isEmpty() {
        return end < 0;
    }

    public void print() {
        for (int i = 0; i <= end; ++i) {
            System.out.println(value[i][0]);
        }
        System.out.println('$');
    }
}
