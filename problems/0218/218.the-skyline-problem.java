class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length < 1)
            return new ArrayList<>();
        return getSkyline(buildings, 0, buildings.length);
    }

    private List<List<Integer>> getSkyline(int[][] buildings, int start, int end) {
        List<List<Integer>> ans = new ArrayList<>();
        if (start == end - 1) {
            ans.add(new ArrayList<>(Arrays.asList(buildings[start][0], buildings[start][2])));
            ans.add(new ArrayList<>(Arrays.asList(buildings[start][1], 0)));
            return ans;
        }
        int mid = (start + end) / 2;

        List<List<Integer>> leftSkyLine = getSkyline(buildings, start, mid);
        List<List<Integer>> rightSkyLine = getSkyline(buildings, mid, end);

        int i = 0, j = 0, leftHeight = 0, rightHeight = 0;
        while (i < leftSkyLine.size() && j < rightSkyLine.size()) {
            List<Integer> left = leftSkyLine.get(i);
            List<Integer> right = rightSkyLine.get(j);

            if (left.get(0) < right.get(0)) {
                leftHeight = left.get(1);
                if (ans.isEmpty() || ans.get(ans.size()-1).get(1) != Math.max(leftHeight, rightHeight))
                    ans.add(new ArrayList<>(Arrays.asList(
                        left.get(0),
                        Math.max(leftHeight, rightHeight)
                    )));
                ++i;
            } else if (left.get(0) > right.get(0)) {
                rightHeight = right.get(1);
                if (ans.isEmpty() || ans.get(ans.size()-1).get(1) != Math.max(leftHeight, rightHeight))
                    ans.add(new ArrayList<>(Arrays.asList(
                        right.get(0),
                        Math.max(leftHeight, rightHeight)
                    )));
                ++j;
            } else {
                leftHeight = left.get(1);
                rightHeight = right.get(1);
                if (ans.isEmpty() || ans.get(ans.size()-1).get(1) != Math.max(leftHeight, rightHeight))
                    ans.add(new ArrayList<>(Arrays.asList(
                        right.get(0),
                        Math.max(leftHeight, rightHeight)
                    )));
                ++j;
                ++i;
            }
        }

        for (; i < leftSkyLine.size(); ++i)
            ans.add(new ArrayList<>(leftSkyLine.get(i)));

        for (; j < rightSkyLine.size(); ++j)
            ans.add(new ArrayList<>(rightSkyLine.get(j)));

        return ans;
    }
}
