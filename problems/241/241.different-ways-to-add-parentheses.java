class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Object> exp = new ArrayList<>();
        int cache = 0;
        input = "0" + input;
        for (int i = 0; i < input.length(); ++i) {
            int n = input.charAt(i) - '0';
            if (n >= 0 && n <= 9) {
                cache = cache * 10 + n;
            } else {
                exp.add(cache);
                cache = 0;
                exp.add(input.charAt(i));
            }
        }
        exp.add(cache);
        return computeRegion(exp, 0, exp.size());
    }

    private List<Integer> computeRegion(List<Object> exp, int start, int end) {
        List<Integer> ans = new ArrayList<>();
        if (start >= end) {
            return ans;
        }
        if (start == end - 1) {
            ans.add((int) exp.get(start));
        }
        for (int i = start; i < end; ++i) {
            if (exp.get(i) instanceof Character) {
                char op = (char) exp.get(i);
                List<Integer> left = computeRegion(exp, start, i);
                expandEmptyAns(left, op);
                List<Integer> right = computeRegion(exp, i+1, end);
                expandEmptyAns(right, op);
                switch (op) {
                    case '+':
                        for (int j = 0; j < left.size(); ++j)
                            for (int k = 0; k < right.size(); ++k)
                                ans.add(left.get(j) + right.get(k));
                        break;
                    case '-':
                        for (int j = 0; j < left.size(); ++j)
                            for (int k = 0; k < right.size(); ++k)
                                ans.add(left.get(j) - right.get(k));
                        break;
                    case '*':
                        for (int j = 0; j < left.size(); ++j)
                            for (int k = 0; k < right.size(); ++k)
                                ans.add(left.get(j) * right.get(k));
                        break;
                }
            }
        }
        return ans;
    }

    private void expandEmptyAns(List<Integer> ans, char op) {
        if (ans.isEmpty()) {
            if (op == '*')
                ans.add(1);
            else
                ans.add(0);
        }
    }
}
