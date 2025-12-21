class Solution {
    public String reverseStr(String s, int k) {
        char [] str = s.toCharArray();
        int n = str.length;
        int i = 0;
        while(i<n){
            int j = Math.min(i+k-1 , n-1);
            reversed(str,i,j);
            i = i+2*k;
        } 
        return new String(str);
    } 
    public void reversed(char[] str,int i ,int j){
        while(i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}