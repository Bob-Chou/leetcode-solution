class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        char[] builder = new char[s.length()];
        int period = 2 * numRows - 2;
        int curIndex = 0;
        for (int i = 0; i < numRows; ++i) {
            int zig = i;
            int zag = (period - i) % period;
            int j = 0;
            while (true) {
                if (j*period + zig < s.length()){
                    builder[curIndex++] = s.charAt(j*period + zig);
                } else {
                    break;
                }
                if (j*period + zag < s.length()) {
                    if (zag != zig)
                        builder[curIndex++] = s.charAt(j*period + zag);
                } else {
                    break;
                }
                ++j;
            }
        }
        return String.valueOf(builder);
    }
}
