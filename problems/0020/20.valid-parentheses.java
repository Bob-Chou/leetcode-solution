class Solution {
    public boolean isValid(String s) {
        Stack<Character> cache = new Stack<>();
        boolean rtn = true;
        for (int i = 0; i < s.length() && rtn; ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                cache.push(ch);
            } else {
                rtn &= ! cache.empty();
                if (rtn) {
                    switch (cache.pop()) {
                        case '(':
                            rtn &= ch == ')';
                            break;
                        case '[':
                            rtn &= ch == ']';
                            break;
                        case '{':
                            rtn &= ch == '}';
                            break;
                    }
                }
            }
        }
        rtn &= cache.empty();
        return rtn;
    }
}
