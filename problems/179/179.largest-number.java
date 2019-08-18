class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        boolean allZero = true;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                allZero = false;
            strNums[i] = String.valueOf(nums[i]);
        }

        if (allZero)
            return "0";

        Arrays.sort(strNums, (a, b) -> {
            int p = 0;
            while (p < a.length() + b.length()) {
                if (a.charAt(p % a.length()) < b.charAt(p % b.length())) {
                    return 1;
                } else if (a.charAt(p % a.length()) > b.charAt(p % b.length())) {
                    return -1;
                }
                ++p;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for (String n : strNums) {
            sb.append(n);
        }
        return sb.toString();
    }

    private class NumComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (b + a).compareTo(a + b);
        }
    }
}

