class Solution {
    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[p.length()+1][s.length()+1];
        match[0][0] = true;
        for (int i = 1; i < p.length() + 1; ++i) {
            for (int j = 0; j < s.length() + 1; ++j) {
                if (j == 0)
                    match[i][j] = (p.charAt(i-1) == '*') && match[i-1][j];
                else if (p.charAt(i-1) == '*')
                    match[i][j] = match[i][j-1] || match[i-1][j-1] || match[i-1][j] || i-1 <= j && match[i-1][i-1];
                else if (p.charAt(i-1) == '?')
                    match[i][j] = match[i-1][j-1];
                else
                    match[i][j] = match[i-1][j-1] && (p.charAt(i-1) == s.charAt(j-1));
            }
        }
        return match[p.length()][s.length()];
    }
}
