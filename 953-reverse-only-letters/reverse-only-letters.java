class Solution {
    public String reverseOnlyLetters(String s) {
       int si = 0;
       int ei = s.length()-1;
       char ch[] = s.toCharArray();
       while(si<=ei){
        if(!Character.isLetter(ch[si])){
            si++;
        }else if(!Character.isLetter(ch[ei])){
            ei--;
        }else{
            char temp = ch[si];
            ch[si] = ch[ei];
            ch[ei] = temp;
            si++;
            ei--;
        }
       }
       return new String(ch); 
    }
}