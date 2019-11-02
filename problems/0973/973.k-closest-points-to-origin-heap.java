class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PiorityQueue<int[]>(new Comparator<int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
            }
        });

        for (int[] point : points) {
            if (pq.size() < K) {
                pq.offer(point)
            } else {
                int[] top = pq.peek();
                if (point[0]*point[0] + point[1]*point[1] < top[0]*top[0] + top[1]*top[1]) {
                    pq.poll();
                    pq.offer(point);
                }
            }
        }

        int[][] ans = new int[K][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
