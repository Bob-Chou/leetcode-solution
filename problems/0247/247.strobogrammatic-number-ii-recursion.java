class Solution {
    private static final Set<String> one = new HashSet<>(Arrays.asList("0", "1", "8"));
    private static final Set<String> two = new HashSet<>(Arrays.asList("11","69","88","96"));
    public List<String> findStrobogrammatic(int n) {
        if (n == 1)
            return new ArrayList<>(one);
        if (n==2)
            return new ArrayList<>(two);
        Set<String> oneCache = new OrderedHashSet<>(two);
        Set<String> twoCache = new OrderedHashSet<>(one);
        two.add("00");
        StringBuilder helper = new StringBuilder();
        for (int i = 3; i <= n; ++i) {
            Set<String> tmp = new OrderedHashSet<>();
            for (String s1 : twoCache) {
                for (String s2 : two) {
                    for (int j = 0; j <= (i-2)/2; ++j) {
                        helper.setLength(0);
                        int p = 0;
                        if (j==0 && s2.charAt(0)=='0')
                            continue;
                        for (int k = 0; k < i; ++k) {
                            if (k==j)
                                helper.append(s2.charAt(0));
                            else if (k==i-j-1)
                                helper.append(s2.charAt(1));
                            else
                                helper.append(s1.charAt(p++));
                        }
                        tmp.add(helper.toString());
                    }
                }
            }
            twoCache = oneCache;
            oneCache = tmp;
        }

        List<String> ans = new ArrayList<>(oneCache);
        Collections.sort(ans, (a, b) -> a.compareTo(b));
    }
}
