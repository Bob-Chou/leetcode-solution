class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, sum = 0, total = 0;
        for (int i = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                // cannot arrive at i from last start station
                // note that the sum at start station is promised to be positive
                // so starting at any station between start and i cannot arrive at i
                // the new start station should be i + 1;
                sum = 0;
                start = i + 1;
            }
        }
        if (total >= 0)
            return start;
        else
            return -1;
    }
}
