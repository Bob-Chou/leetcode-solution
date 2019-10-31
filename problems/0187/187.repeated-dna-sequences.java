class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        byte[] encoder = new byte[Integer.valueOf('T') + 1];
        encoder['A'] = 0;
        encoder['C'] = 1;
        encoder['G'] = 2;
        encoder['T'] = 3;
        int mask = 0x000fffff;
        int code = 0;
        byte[] seen = new byte[mask];

        for (int i = 0; i < 9; ++i)
            code = (code << 2) | encoder[s.charAt(i)];

        for (int i = 9; i < s.length(); ++i) {
            code = (code << 2) | encoder[s.charAt(i)];
            code &= mask;
            if (seen[code] == 0) {
                seen[code] = 1;
            } else if (seen[code] == 1) {
                ans.add(s.substring(i - 9, i + 1));
                seen[code] = 2;
            }
        }
        return ans;
    }
}
