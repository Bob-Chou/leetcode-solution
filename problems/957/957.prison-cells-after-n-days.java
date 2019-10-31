class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int prev = 0, next = 0, mask = 0;
        int[] stateToStep = new int[1 << cells.length];
        int[] stepToState = new int[1 << cells.length];

        for (int i = 0; i < cells.length - 2; ++i) {
            mask <<= 1;
            mask |= 2;
        }

        for (int n : cells) {
            prev <<= 1;
            prev |= n;
        }

        int n = 0;
        while (n < N) {
            ++n;
            int leftShiftNum = prev << 1;
            int rightShiftNum = prev >> 1;
            next = ((leftShiftNum ^ rightShiftNum) & mask) ^ mask;
            if (stateToStep[next] != 0)
                break;
            stateToStep[next] = n;
            stepToState[n] = next;
            prev = next;
        }

        if (n < N) {
            next = stepToState[(N-n) % (n-stateToStep[next]) + stateToStep[next]];
        }

        for (int i = 0; i < cells.length; ++i) {
            cells[cells.length-i-1] = next & 1;
            next >>= 1;
        }

        return cells;
    }
}
