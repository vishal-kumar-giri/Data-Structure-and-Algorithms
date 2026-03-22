class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        
        for(char ch : s.toCharArray()){
            count[ch]++;
        }

        int res = 0;
        boolean hasOdd = false;

        for(int i = 0; i < 128; i++){
            int val = count[i];
            
            res += (val / 2) * 2;
            
            if(val % 2 == 1){
                hasOdd = true;
            }
        }

        // ek odd center me use kar sakte hain
        if(hasOdd) res++;

        return res;
    }
}