class Solution {
    public void reverseString(char[] s) {
       int si = 0;
       int ei = s.length-1;
       while(si<=ei){
        char ch = s[si];
        s[si] = s[ei];
        s[ei] = ch;
        si++;
        ei--;
       } 
    }
}