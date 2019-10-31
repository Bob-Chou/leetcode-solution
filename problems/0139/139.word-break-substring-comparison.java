class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] helper = new boolean[s.length()+1];
        helper[0] = true;
        for (int i = 0; i < helper.length; ++i) {
            for (String vocab : wordDict) {
                if (!helper[i] && i - vocab.length() >= 0) {
                    helper[i] = helper[i-vocab.length()] && s.substring(i-vocab.length(), i).equals(vocab);
                }
            }
        }
        return helper[s.length()];
    }
}
