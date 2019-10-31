class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] counter = new int['z'-'A'+1];
        int distinct = 0;
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (counter[s.charAt(i) - 'A']++ == 0)
                ++distinct;

            while (distinct > 2)
                if (--counter[s.charAt(left++) - 'A'] == 0)
                    --distinct;

            if (i - left + 1 > ans)
                ans = i - left + 1;
        }
        return ans;
    }
}
