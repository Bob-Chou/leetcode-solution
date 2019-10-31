class Solution {
    public int divide(int dividend, int divisor) {
        boolean negFlag = false;
        if (divisor > 0 && dividend < 0 || divisor < 0 && dividend > 0)
            negFlag = true;

        if (dividend > 0)
            dividend = - dividend;

        if (divisor > 0)
            divisor = - divisor;

        if (!negFlag && divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        int quotient = 0;

        while (dividend <= divisor) {
            int curQuotient = 1;
            int curDivisor = divisor;
            while (curDivisor << 1 < 0 && dividend <= curDivisor << 1) {
                curQuotient <<= 1;
                curDivisor <<= 1;
            }
            quotient -= curQuotient;
            dividend -= curDivisor;
        }

        return negFlag ? quotient : - quotient;
    }
}
