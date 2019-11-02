class Solution {
    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length + num2.length + 1];
        for (int i = num1.length - 1; i >= 0; --i) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            for (int j = num1.length - 1; j >= 0; --j) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + carry + ans[i + j + 1];
                ans[i + j + 1] = sum % 10;
                carry = sum / 10;
            }

            while (carry > 0) {
                ans[i + j + 1] = carry % 10;
                carry /= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean skipZero = true;
        for (int i = 0; i < ans.length; ++i) {
            if (skipZero && ans[i] == 0)
                continue;
            skipZero = false;
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}
