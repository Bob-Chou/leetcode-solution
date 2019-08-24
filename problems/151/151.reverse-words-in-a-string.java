class Solution {
    public String reverseWords(String s) {
        String[] stringArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = stringArray.length - 1; i >= 0; i--) {
            // System.out.println(i+" + "+ stringArray[i]);
            if (stringArray[i].equals(" ") || stringArray[i].length() == 0) continue;
            sb.append(stringArray[i]);
            sb.append(" ");
        }
        // System.out.println(sb.toString().trim());
        return sb.toString().trim();
    }
}
