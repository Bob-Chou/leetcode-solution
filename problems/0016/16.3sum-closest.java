class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0;
            int right = nums.length - 1;
            while (left < i && right > i) {
                int curGap = nums[i] + nums[left] + nums[right] - target;
                if (Math.abs(curGap) < Math.abs(minGap)) {
                    minGap = curGap;
                }
                if (curGap < 0){
                    left += 1;
                } else if (curGap > 0) {
                    right -= 1;
                } else {
                    return target;
                }
            }
        }
        return minGap + target;
    }
}
