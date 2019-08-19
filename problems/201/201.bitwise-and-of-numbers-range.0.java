class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int max = 1;

        while (m != n) {
            if (m == 0) return 0;
            m >>= 1;
            n >>= 1;
            max <<= 1;
        }
        return max * m;
    }
}
