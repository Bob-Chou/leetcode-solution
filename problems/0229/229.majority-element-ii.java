class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int major1 = 0, major2 = 0, cnt1 = 0, cnt2 = 0;
        for (int n : nums) {
            if (n == major2) {
                ++cnt2;
            } else if (n == major1) {
                ++cnt1;
            } else if (cnt1 == 0) {
                major1 = n;
                ++cnt1;
            } else if (cnt2 == 0) {
                major2 = n;
                ++cnt2;
            } else {
                --cnt1;
                --cnt2;
            }
        }

        if (cnt1 > 0) {
            cnt1 = 0;
            for (int n : nums) {
                if (n == major1)
                    ++cnt1;
            }
            if (cnt1 > nums.length / 3)
                ans.add(major1);
        }

        if (cnt2 > 0) {
            cnt2 = 0;
            for (int n : nums) {
                if (n == major2)
                    ++cnt2;
            }
            if (cnt2 > nums.length / 3)
                ans.add(major2);
        }

        return ans;
    }
}
