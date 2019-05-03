class Solution {
    public int countSubstrings(String s) {
        boolean[][] helper = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j >= 0; --j) {
                helper[i][j] = i == j || s.charAt(i) == s.charAt(j) && (i<j+2 || helper[i-1][j+1]);
                if (helper[i][j]) ++cnt;
            }
        }
        return cnt;
    }
}
