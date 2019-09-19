class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        StringBuilder sb = new StringBuilder(s);
        sb.append("$");
        for (int i = s.length() - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }
        String str = sb.toString();
        int[] helper = new int[str.length()];
        for (int i = 1; i < str.length(); ++i) {
            int j = helper[i-1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = helper[j-1];
            }
            if (str.charAt(i) == str.charAt(j))
                ++j;
            helper[i] = j;
        }
        sb.setLength(0);
        for (int i = s.length() - 1; i >= helper[helper.length-1]; --i) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
}
