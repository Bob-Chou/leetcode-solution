class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < 1 || t.length() < 1) return "";
        Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
        for (char target : t.toCharArray()) {
            if (!targetMap.containsKey(target)) targetMap.put(target, 1);
            else targetMap.put(target, targetMap.get(target) + 1);
        }

        int reached = 0;
        int right = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        char key;
        while (right < s.length()) {
            key = s.charAt(right);
            if (targetMap.containsKey(key)) {
                int n = targetMap.get(key);
                if (--n >= 0) {
                    ++reached;
                }
                targetMap.put(key, n);
            }
            while (reached == t.length()) {
                key = s.charAt(left);
                if (targetMap.containsKey(key)) {
                    int n = targetMap.get(key);
                    if (++n > 0) {
                        --reached;
                        if (right - left + 1 < minLength) {
                            minLength = right - left + 1;
                            ans = s.substring(left, right + 1);
                        }
                    }
                    targetMap.put(key, n);
                }
                ++left;
            }
            ++right;
        }

        return ans;
    }
}
