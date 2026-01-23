class Solution {
    public int operate(int a, int b, String token) {
        if (token.equals("+")) return a + b;
        if (token.equals("-")) return a - b;
        if (token.equals("*")) return a * b;
        if (token.equals("/")) return a / b;
        return 0;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();
                int res = operate(a, b, token);
                stack.push(res);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
