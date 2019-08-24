class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Arrays.asList(1));
            return ans;
        } else {
            List<List<Integer>> lastTriangle = generate(numRows - 1);
            List<Integer> lastRow = lastTriangle.get(lastTriangle.size()-1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int i = 1; i < lastRow.size(); ++i) {
                newRow.add(lastRow.get(i-1)+lastRow.get(i));
            }
            newRow.add(1);
            lastTriangle.add(newRow);
            return lastTriangle;
        }
    }
}
