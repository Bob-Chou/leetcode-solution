class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        genNextParenthesis(0, n, "", ret);
        return ret;
    }

    private void genNextParenthesis (int unmatched, int unused, String seq, List<String> ret) {
        if (unused == 0 && unmatched == 0) {
            ret.add(seq);
        }
        if (unmatched > 0) {
            genNextParenthesis(unmatched - 1, unused, seq + ")", ret);
        }
        if (unused > 0) {
            genNextParenthesis(unmatched + 1, unused - 1, seq + "(", ret);
        }
    }
}
