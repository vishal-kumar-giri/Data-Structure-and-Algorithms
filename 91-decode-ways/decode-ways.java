class Solution {
    public int numDecodings(String s) {
        int prev2 = 1;
        int prev1 = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += prev2;
            }
            if (i > 0) {
                int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                if (num >= 10 && num <= 26) {
                    current += prev1;
                }
            }
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}