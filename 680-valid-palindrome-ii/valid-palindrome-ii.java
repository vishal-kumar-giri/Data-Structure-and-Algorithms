class Solution {
    public boolean validPalindrome(String s) {
       int i = 0;
       int j = s.length()-1;
       while(i<=j){
        if(s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }else{
            return palindrome(s,i+1,j) || palindrome(s,i,j-1);
        }
       }
       return true;
    }
    public boolean palindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}