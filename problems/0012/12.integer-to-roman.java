class Solution {
    private Map<Integer, Character> dict;
    public Solution() {
        dict = new HashMap<>();
        dict.put(1, 'I');
        dict.put(5, 'V');
        dict.put(10, 'X');
        dict.put(50, 'L');
        dict.put(100, 'C');
        dict.put(500, 'D');
        dict.put(1000, 'M');
    }
    public String intToRoman(int num) {
        StringBuilder constructor = new StringBuilder();
        int multiplier = 1;
        int end = 14;
        for (; num > 0; num /= 10) {
            int digit = num % 10;
            if (0 < digit && digit < 4) {
                for (; digit > 0; --digit)
                    constructor.append(dict.get(multiplier));
            } else if (digit == 4) {
                constructor.append(dict.get(5 * multiplier));
                constructor.append(dict.get(multiplier));
            } else if (4 < digit && digit < 9) {
                for (; digit > 5; --digit)
                    constructor.append(dict.get(multiplier));
                constructor.append(dict.get(5 * multiplier));
            } else if (digit == 9) {
                constructor.append(dict.get(10 * multiplier));
                constructor.append(dict.get(multiplier));
            }
            multiplier *= 10;
        }

        return constructor.reverse().toString();
    }
}
