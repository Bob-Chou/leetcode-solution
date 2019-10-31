class Solution {
    public String decodeString(String s) {
        Stack<Character> expression = new Stack<>();
        String ans = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ']') {
                String encoded = "";
                while (!expression.empty() && expression.peek() != '[') {
                    encoded = expression.pop() + encoded;
                }
                expression.pop();

                int multiplier = 0;
                for (int carry = 1; !expression.empty() && Character.isDigit(expression.peek()); carry *= 10) {
                    multiplier += (expression.pop() - '0') * carry;
                }

                for (; multiplier > 0; --multiplier) {
                    for (int j = 0; j < encoded.length(); ++j) {
                        expression.push(encoded.charAt(j));
                    }
                }
            } else {
                expression.push(c);
            }
        }

        while (!expression.empty()) {
            ans = expression.pop() + ans;
        }

        return ans;
    }
}
