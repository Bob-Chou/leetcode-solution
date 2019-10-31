class Solution {
    private static final class NumTracker {
        public int index;
        public int num;
        public NumTracker(int val, int idx) {
            num = val;
            index = idx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length < 1)
            return new ArrayList<>();

        List<NumTracker> tracker = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            tracker.add(new NumTracker(nums[i], i));
            count.add(0);
        }
        splitAndMerge(tracker, 0, tracker.size(), count);
        return count;

    }

    private static final List<NumTracker> splitAndMerge(List<NumTracker> l, int start, int end, List<Integer> count) {
        if (start >= end - 1) {
            return new ArrayList<>(l.subList(start, start+1));
        }

        List<NumTracker> left = splitAndMerge(l, start, (start+end)/2, count);
        List<NumTracker> right = splitAndMerge(l, (start+end)/2, end, count);
        return mergeAndCount(left, right, count);
    }

    private static final List<NumTracker> mergeAndCount(List<NumTracker> left, List<NumTracker> right, List<Integer> count) {
        int i = 0;
        int j = 0;
        List<NumTracker> merged = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            if (left.get(i).num <= right.get(j).num) {
                merged.add(left.get(i));
                count.set(left.get(i).index, count.get(left.get(i).index)+j);
                ++i;
            } else {
                merged.add(right.get(j));
                ++j;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            count.set(left.get(i).index, count.get(left.get(i).index)+j);
            ++i;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            ++j;
        }

        return merged;
    }
}
