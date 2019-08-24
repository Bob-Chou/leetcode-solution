class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        int start = nums[0], end = nums[0];

        for (int n : nums) {
            if (n > end + 1) {
                addString(ans, start, end);
                start = n;
                end = n;
            } else {
                end = n;
            }
        }
        addString(ans, start, end);
        return ans;
    }

    private void addString(List<String> ans, int start, int end) {
        if (start == end)
            ans.add(String.valueOf(start));
        else
            ans.add(String.valueOf(start)+"->"+String.valueOf(end));
    }
}
