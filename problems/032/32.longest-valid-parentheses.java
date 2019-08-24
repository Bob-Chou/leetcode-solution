class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int reached = 0;
        int scanLength = 0;
        if (s.length() < 2) return 0;
        while (reached < s.length()) {
            scanLength = maxLengthFrom(s, reached);
            if (scanLength > maxLength) {
                maxLength = scanLength;
            }
            reached += scanLength + 1;
        }
        return maxLength;
    }
    private int maxLengthFrom(String s, int start) {
        int matchedLength = 0;
        int openDepth = 0;
        int scanner = start;
        for (; scanner < s.length(); ++scanner) {
            if (openDepth == 0) {
                if (s.charAt(scanner) == ')') {
                    break;
                } else {
                    ++openDepth;
                }
            } else {
                if (s.charAt(scanner) == ')') {
                    --openDepth;
                } else {
                    ++openDepth;
                }
            }
        }

        if (openDepth == 0) {
            matchedLength = scanner - start;
        }

        return matchedLength;
    }
}
