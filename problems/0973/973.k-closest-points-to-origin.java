class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int start = 0;
        int end = points.length;
        while (start < end) {
            int mid = (start + end) /2;
            int loc = quickSortSingleStep(points, start, end - 1, mid);
            if (loc == k) {
                break;
            } else if (loc < k) {
                start = loc + 1;
            } else {
                end = loc;
            }
        }
        return ;
    }

    public int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    public void swap(int[][] points, int p1, int p2) {
        int[] tmp = points[p1];
        points[p1] = points[p2];
        points[p2] = tmp;
    }

    public int quickSortSingleStep(int[][] points, int start, int end, int pivot) {
        swap(points, start, pivot);
        while (true) {
            while (start < end && dist(points[start]) <= dist(points[end])) { --end; }
            if (start == end) break;
            swap(points, start, end);
            while (start < end && dist(points[start]) <= dist(points[end])) { ++start; }
            if (start == end) break;
            swap(points, start, end);
        }
        return start;
    }
}
