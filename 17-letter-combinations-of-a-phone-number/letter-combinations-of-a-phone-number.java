import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] keypad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        backtrack(digits, 0, "", result, keypad);
        return result;
    }
    private void backtrack(
            String digits,
            int index,
            String current,
            List<String> result,
            String[] keypad) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = keypad[digit];
        for (char ch : letters.toCharArray()) {
            backtrack(
                digits,
                index + 1,
                current + ch,
                result,
                keypad
            );
        }
    }
}