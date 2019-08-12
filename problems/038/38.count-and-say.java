class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String lastCount = countAndSay(n-1);
            StringBuilder ans = new StringBuilder();
            int count = 1;
            int i;
            for (i = 1; i < lastCount.length(); ++i) {
                char c = lastCount.charAt(i);
                if (c == lastCount.charAt(i-1)) {
                    ++count;
                } else {
                    ans.append(count).append(lastCount.charAt(i-1));
                    count = 1;
                }
            }
            ans.append(count).append(lastCount.charAt(i-1));
            return ans.toString();
        }
    }
}
