class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] helper = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            getPalindromeHelper(s, i, i, helper);
            getPalindromeHelper(s, i, i+1, helper);
        }
        partitionRegion(helper, s, 0, s.length(), new ArrayList<>(), ans);
        return ans;
    }

    private void partitionRegion(boolean[][] helper, String s, int start, int end, List<String> parts, List<List<String>> ans) {
        if (start >= end) {
            ans.add(new ArrayList<>(parts));
        } else {
            for (int i = start; i < end; ++i) {
                if (helper[start][i]) {
                    parts.add(s.substring(start, i + 1));
                    partitionRegion(helper, s, i + 1, end, parts, ans);
                    parts.remove(parts.size()-1);
                }
            }
        }
    }

    private void getPalindromeHelper(String s, int l, int r, boolean[][] helper) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            helper[l][r] = true;
            --l;
            ++r;
        }
    }
}
