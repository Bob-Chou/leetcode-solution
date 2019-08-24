class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String s : tokens) {
            char op = s.charAt(s.length()-1);
            int a, b;
            switch (op) {
                case '*':
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a * b);
                    break;
                case '/':
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a / b);
                    break;
                case '+':
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a + b);
                    break;
                case '-':
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a - b);
                    break;
                default:
                    numbers.push(Integer.parseInt(s));
            }
        }
        return numbers.pop();
    }
}
