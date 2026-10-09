class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openNeeded = 0; 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (openNeeded % 2 != 0) {
                    insertions++; 
                    openNeeded--;  
                }
                openNeeded += 2;   
            } else {
                openNeeded--;
                if (openNeeded == -1) {
                    insertions++;  
                    openNeeded = 1; 
                }
            }
        }
        return insertions + openNeeded;
    }
}