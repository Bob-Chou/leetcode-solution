class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask;
        for (mask = 0xffffffff; ~mask < n - m; mask <<= 1);
        return mask & m & n;
    }
}
