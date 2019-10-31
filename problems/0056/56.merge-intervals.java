/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        intervalQuickSort(intervals, 0, intervals.size() - 1);
        if (intervals.size() > 0) {
            int left = intervals.get(0).start;
            int right = intervals.get(0).end;

            for (int i = 1; i < intervals.size(); ++i) {
                Interval s = intervals.get(i);
                if (s.start > right) {
                    ans.add(new Interval(left, right));
                    left = s.start;
                    right = s.end;
                } else {
                    left = Math.min(left, s.start);
                    right = Math.max(right, s.end);
                }
            }
            ans.add(new Interval(left, right));
        }

        return ans;
    }

    private void intervalQuickSort(List<Interval> intervals, int left, int right) {
        if (left >= right) return;
        int cache = intervals.get(left).start;
        int i = left;
        int j = right;
        while (j > i) {
            while (intervals.get(j).start >= cache && j > i) {
                --j;
            }
            if (j == i) break;
            intervalSwap(intervals, i, j);

            while (intervals.get(i).start <= cache && j > i) {
                ++i;
            }
            if (j == i) break;
            intervalSwap(intervals, i, j);
        }
        intervalQuickSort(intervals, left, i - 1);
        intervalQuickSort(intervals, j + 1, right);
    }

    private void intervalSwap(List<Interval> intervals, int left, int right) {
        Interval tmp = intervals.get(left);
        intervals.set(left, intervals.get(right));
        intervals.set(right, tmp);
    }
}
