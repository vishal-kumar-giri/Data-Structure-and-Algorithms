class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    str.setCharAt(i, '*');
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            str.setCharAt(index, '*');
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*') {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}