class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        String str = sb.toString();

        int pivot = 0;
        int start = 0;
        int center = 0;
        int[] helper = new int[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            int j = i + 1;
            if (i < helper[center]+ center) {
                j = Math.min(helper[2*center-i]+i, helper[center]+center);
            }
            for (; j < str.length() && 2*i-j>=0; ++j) {
                if (str.charAt(2*i-j)!=str.charAt(j))
                    break;
            }
            helper[i] = j - i;
            if (helper[i] + i > helper[center] + center) {
                center = i;
            }
            if (2 * i - j + 1 == 0) {
                pivot = i;
                start = j;
            }
        }
        sb.setLength(0);
        for (int i = str.length() - 1; i >= start; --i) {
            if (str.charAt(i) != '#')
                sb.append(str.charAt(i));
        }
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != '#')
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
