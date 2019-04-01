class Solution {

    private Map<String, String> numberDecoder;

    Solution() {
        numberDecoder = new HashMap<>();
        numberDecoder.put("2", "abc");
        numberDecoder.put("3", "def");
        numberDecoder.put("4", "ghi");
        numberDecoder.put("5", "jkl");
        numberDecoder.put("6", "mno");
        numberDecoder.put("7", "pqrs");
        numberDecoder.put("8", "tuv");
        numberDecoder.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        recursiveCombination(digits, 0, "", combinations);

        return combinations;
    }

    private void recursiveCombination(String digits, int depth, String cache, List<String> combinations) {
        if (depth >= digits.length()) {
            return;
        }
        String letters = numberDecoder.get(digits.substring(depth, depth+1));
        for (int i = 0; i < letters.length(); ++i) {
            if (depth == digits.length() - 1) {
                combinations.add(cache + letters.charAt(i));
            } else {
                recursiveCombination(digits, depth + 1, cache + letters.charAt(i), combinations);
            }
        }
    }
}
