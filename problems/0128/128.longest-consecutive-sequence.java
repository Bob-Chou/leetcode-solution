class Solution {
    private int longest;
    private Map<Integer, Integer> uf;
    private Map<Integer, Integer> lengths;

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        uf = new HashMap<>();
        lengths = new HashMap<>();
        longest = 1;

        for (int n : nums) {
            uf.put(n, n);
            lengths.put(n, 1);
        }

        uf.keySet().forEach(k -> consecutiveUnion(k));

        return longest;
    }

    private int getRoot(int n) {
        while (n != uf.get(n)) {
            uf.put(n, uf.get(uf.get(n)));
            n = uf.get(n);
        }
        return n;
    }

    private void consecutiveUnion(int n) {
        int r = getRoot(n);
        if (uf.containsKey(n-1)) {
            r = quickRootUnion(r, getRoot(n-1));
        }
        if (uf.containsKey(n+1)) {
            quickRootUnion(r, getRoot(n+1));
        }
    }

    private int quickRootUnion(int n1, int n2) {
        if (n1 != n2) {
            if (lengths.get(n2) < lengths.get(n1)) {
                uf.put(n2, uf.get(n1));
                lengths.put(n1, lengths.get(n1) + lengths.get(n2));
                if (lengths.get(n1) > longest)
                    longest = lengths.get(n1);
            } else {
                uf.put(n1, uf.get(n2));
                lengths.put(n2, lengths.get(n1) + lengths.get(n2));
                if (lengths.get(n2) > longest)
                    longest = lengths.get(n2);
            }
        }
        return uf.get(n1);
    }
}
