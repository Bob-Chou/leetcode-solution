class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> ansMap = new HashMap<>();
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String k = String.valueOf(sArray);
            try {
                ansMap.get(k).add(s);
            } catch(Exception e) {
                ansMap.put(k, new ArrayList<>(Arrays.asList(s)));
            }
        }

        for (List<String> group : ansMap.values()) {
            ans.add(group);
        }
        return ans;
    }
}
