class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        MultiSet maxRange = new MultiSet();
        MultiSet minRange = new MultiSet();
        int leftMost = 0;
        int leftLeast = 0;
        int ans = 0;

        for (int i = 0; i < A.length; ++i) {
            int x = A[i];
            maxRange.add(x);
            minRange.add(x);

            while (maxRange.length() > K) maxRange.remove(A[leftMost++]);
            while (minRange.length() >= K) minRange.remove(A[leftLeast++]);

            ans += leftLeast - leftMost;
        }

        return ans;
    }

    class MultiSet {
        private int[] counter;
        private int length;
        public MultiSet(int size) { counter = new int[size]; }
        public void add(int x) { if (++counter[x] == 1) ++length; }
        public void remove(int x) { if (--counter[x] == 0) --length; }
        public int length() { return length; }
    }
    /*
    class MultiSet {
        private int size;
        private Map<Integer, Integer> counter = new HashMap<>();

        public MultiSet() { counter = new HashMap<>(); }

        public int size() { return counter.size(); }

        public void add(int x) { counter.put(x, counter.getOrDefault(x, 0) + 1); }

        public void remove(int x) {
            int cnt = counter.get(x);
            if (--cnt == 0)
                counter.remove(x);
            else
                counter.put(x, cnt);
        }
    }
    */
}
