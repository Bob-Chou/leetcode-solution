class Solution {
    public void moveZeroes(int[] nums) {
        int behind = 0, ahead = 0;
        while (ahead < nums.length) {
            while (behind < nums.length && nums[behind] != 0) {
                ++behind;
            }
            while (ahead < behind || ahead < nums.length && nums[ahead] == 0) {
                ++ahead;
            }
            if (ahead < nums.length) {
                nums[behind] = nums[ahead];
                nums[ahead] = 0;
                ++behind;
                ++ahead;
            }
        }
    }
}
