class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        int start = 0;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;

            if (count == 0) {
                ans += s.substring(start + 1, i);
                start = i + 1;
            }
        }
        return ans;
    }
}
