class Solution {
    public boolean checkRecord(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L')
                ++cnt1;
            else
                cnt1 = 0;

            if (s.charAt(i) == 'A')
                ++cnt2;

            if (cnt1 > 2 || cnt2 > 1)
                return false;
        }
        return true;
    }
}
