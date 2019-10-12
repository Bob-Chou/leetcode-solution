class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length < 1) {
            return new int[][] {newInterval};
        }

        int start = Arrays.binarySearch(intervals, newInterval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[0]);
            }
        });
        int end = Arrays.binarySearch(intervals, newInterval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[1]);
            }
        });
        start = start >= 0 ? start : -start-1;
        end = end >= 0 ? end+1 : -end-1;

        int[][] ans = new int[intervals.length-end+start+1][2];
        int[] insertInterval = newInterval;
        if (start < intervals.length && end > 0)
            insertInterval = new int[] {
                Math.min(newInterval[0], intervals[start][0]),
                Math.max(newInterval[1], intervals[end-1][1])
            };

        System.arraycopy(intervals, 0, ans, 0, start);
        ans[start] = insertInterval;
        System.arraycopy(intervals, end, ans, start+1, intervals.length-end);

        return ans;
    }
}
