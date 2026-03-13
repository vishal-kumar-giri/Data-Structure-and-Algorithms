class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        
        for(int i=0;i<k;i++){
            if(isVowels(s.charAt(i)))count++;
        }
        int maxSum = count;
        for(int i=k;i<s.length();i++){
            if(isVowels(s.charAt(i)))count++;
            if(isVowels(s.charAt(i-k)))count--;
            maxSum = Math.max(maxSum,count);
        }
        return maxSum;
    }
    public boolean isVowels(char ch){
        return (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u');
    }
}