class Solution {
    public String reverseVowels(String s) {
      char[]str = s.toCharArray();
      int si = 0;
      int ei = str.length-1;
      while(si<=ei){
        if(!isVowels(str[si])){
            si++;
        }else if(!isVowels(str[ei])){
            ei--;
        }else{
            char temp = str[si];
            str[si] =  str[ei];
            str[ei] = temp;
            si++;
            ei--;
        }
      } 
      return new String(str); 
    }
    public boolean isVowels(char ch){
        ch = Character.toLowerCase(ch);
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}