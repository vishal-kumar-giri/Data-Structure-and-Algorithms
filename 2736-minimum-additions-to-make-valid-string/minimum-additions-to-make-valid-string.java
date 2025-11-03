class Solution {
    public int addMinimum(String word) {
        int n = word.length();
        int i = 0;
        int reqLength = 0;
        while(i<n){
            int validLength = 0;
            if(word.charAt(i)=='a'){
                validLength++;
                i++;
            }
            if(i<n && word.charAt(i)=='b'){
                validLength++;
                i++;
            }
            if(i<n && word.charAt(i)=='c'){
                validLength++;
                i++;
            }
            reqLength = reqLength+3-validLength;
        }
        return reqLength;
    }
}