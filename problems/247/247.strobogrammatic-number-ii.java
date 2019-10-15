class Solution {
    private static final char[] middle = new char[] {'0', '1', '8'};
    private static final char[] left = new char[] {'0', '1','6', '8', '9'};
    private static final char[] right = new char[] {'0', '1','9', '8', '6'};
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        char[] number = new char[n/2*2+1];
        if (n % 2 == 1) {
            for (int i = 0; i < middle.length; ++i) {
                number[n/2] = middle[i];
                dfs(n, number, 1, ans);
            }
        } else {
            dfs(n, number, 1, ans);
        }
        return ans;
    }

    private static void dfs(int n, char[] number, int start, List<String> ans) {
        if (start > n/2) {
            ans.add(String.valueOf(number).trim());
            return;
        }
        for (int i = 0; i < left.length; ++i) {
            // '0' cannot be used as start of the number
            if (i == 0 && start == n/2)
                continue;
            number[n/2-start] = left[i];
            number[(n-1)/2+start] = right[i];
            dfs(n, number, start+1, ans);
        }
    }
}
