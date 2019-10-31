class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                return s1[0] - s2[0];
            }
        });
        int parallel = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; ++i) {
            while (!pq.isEmpty() && pq.peek() <= intervals[i][0])
                pq.poll();
            pq.offer(intervals[i][1]);
            parallel = Math.max(parallel, pq.size());
        }

        return parallel;
    }
}
