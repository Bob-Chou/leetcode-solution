class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2)
            return 0;
        int prev = 0;
        int next = 0;
        int step = 0;
        int farthest = 0;
        while (step < nums.length) {
            prev = next;
            if (prev + nums[prev] >= nums.length - 1) {
                ++step;
                break;
            }
            for (int j = prev + 1; j <= prev + nums[prev]; ++j) {
                if (j + nums[j] > farthest) {
                    farthest = j + nums[j];
                    next = j;
                }
            }
            ++step;
        }
        return step;
    }
}
