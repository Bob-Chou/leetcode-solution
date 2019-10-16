class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();

        if (nums == null || nums.length < 1)
            return ans;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            ans.add(0);
            if (n < min)
                min = n;
            if (n > max)
                max = n;
        }

        int size = 1;
        while (size < max - min + 1)
            size <<= 1;

        int[] segTree = new int[2*size-1];

        for (int i = nums.length - 1; i >= 0; --i)
            ans.set(i, checkAndUpdate(segTree, nums[i] - min));

        return ans;
    }

    private int checkAndUpdate(int[] segTree, int n) {
        int idx = 0;
        int count = 0;
        int min = 0;
        int max = (segTree.length + 1) / 2;
        while (idx < segTree.length) {
            int mid = (min + max) / 2;
            if (n >= mid) {
                // count nodes in left segments
                count += 2*idx+1 < segTree.length ? segTree[2*idx+1] : 0;
                // update
                ++segTree[idx];
                // entry the right segment
                idx = 2 * idx + 2;
                min = mid;
            } else {
                // update
                ++segTree[idx];
                // entry the right segment
                idx = 2*idx+1;
                max = mid;
            }
        }
        return count;
    }
}

