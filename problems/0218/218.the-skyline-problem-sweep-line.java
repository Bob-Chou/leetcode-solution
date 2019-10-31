class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeSet<Integer> heights = new TreeSet<>();
        Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<int[]> bounds = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (int[] bld : buildings) {
            bounds.offer(new int[]{bld[0], bld[2]});
            bounds.offer(new int[]{bld[1], -bld[2]});
        }
        heights.add(0);
        int height = 0;
        while (!bounds.isEmpty()) {
            int loc = bounds.peek()[0];
            while (!bounds.isEmpty() && bounds.peek()[0] == loc) {
                int[] bnd = bounds.poll();
                if (bnd[1] > 0) {
                    heights.add(bnd[1]);
                    counts.put(bnd[1], counts.getOrDefault(bnd[1], 0) + 1);
                }
                if (bnd[1] < 0) {
                    int remain = counts.get(-bnd[1]) - 1;
                    counts.put(-bnd[1], remain);
                    if (remain <= 0) {
                        heights.remove(-bnd[1]);
                    }
                }
            }
            int h = heights.last();
            if (h != height) {
                height = h;
                ans.add(new ArrayList<>(Arrays.asList(loc, height)));
            }
        }
        return ans;
    }
}
