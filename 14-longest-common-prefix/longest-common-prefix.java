import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs); // Sort the array

        String str1 = strs[0]; // First word (smallest lexicographically)
        String str2 = strs[strs.length - 1]; // Last word (largest lexicographically)
        int idx = 0;

        // Compare characters until mismatch or one string ends
        while (idx < str1.length() && idx < str2.length()) {
            if (str1.charAt(idx) == str2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        // Return common prefix
        return idx == 0 ? "" : str1.substring(0, idx);
    }
}
