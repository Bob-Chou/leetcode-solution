class Solution {
    public String getPermutation(int n, int k) {
        char[] ans = new char[n];
        boolean[] mask = new boolean[n];
        int divisor = 1;
        for (int i = 1; i < n; ++i)
            divisor *= i;
        while (n > 0) {
            int next = (k - 1) / divisor;
            k -= next * divisor;
            int val = 1;
            for (; next > 0 || next == 0 && mask[val - 1]; ++val) {
                if (!mask[val - 1])
                    --next;
            }
            ans[ans.length - n] = (char)('0' + val);
            mask[val - 1] = true;
            --n;
            if (n > 0)
                divisor /= n;
        }
        return String.valueOf(ans);
    }
}
