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
        // use dummy node
        int[] segTree = new int[max-min+2];

        for (int i = nums.length - 1; i >= 0; --i) {
            ans.set(i, sum(segTree, nums[i] - min));
            update(segTree, nums[i] - min + 1);
        }

        return ans;
    }

    private void update(int[] segTree, int n) {
        int idx = n;
        if (n == 0) {
            ++segTree[n];
        }
        while (n > 0 && n < segTree.length) {
            ++segTree[n];
            n += n & -n;
        }
    }

    private int sum(int[] segTree, int n) {
        if (n <= 0)
            return 0;
        int sum = 0;
        while (n > 0) {
            sum += segTree[n];
            n -= n & -n;
        }
        return sum;
    }
}

