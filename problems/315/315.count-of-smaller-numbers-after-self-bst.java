class Solution {
    private static final class CounterNode {
        private int val;
        // count of left sub-tree
        private int leftCount;
        // count of duplicate of itself
        private int selfCount;
        private CounterNode left;
        private CounterNode right;

        public CounterNode(int v) {
            val = v;
            leftCount = 0;
            selfCount = 1;
        }

        public int insert(int v) {
            if (v == val) {
                ++selfCount;
                return leftCount;
            } else if (v < val) {
                ++leftCount;
                if (left == null) {
                    left = new CounterNode(v);
                    return 0;
                } else {
                    return left.insert(v);
                }
            } else {
                if (right == null) {
                    right = new CounterNode(v);
                    return leftCount + selfCount;
                } else {
                    return leftCount + selfCount + right.insert(v);
                }
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();

        if (nums == null || nums.length < 1)
            return ans;
        for (int i = 0; i < nums.length; ++i)
            ans.add(0);
        CounterNode root = new CounterNode(nums[nums.length-1]);
        for (int i = nums.length - 2; i >= 0; --i)
            ans.set(i, root.insert(nums[i]));

        return ans;
    }
}
