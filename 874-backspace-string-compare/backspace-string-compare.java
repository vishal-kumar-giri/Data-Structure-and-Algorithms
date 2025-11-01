class Solution {
    public boolean backspaceCompare(String s, String t) {
      Stack<Character> ss = new Stack<>();
      Stack<Character> tt = new Stack<>();
      for( char i : s.toCharArray()){
        if(i=='#'){
            if(!ss.isEmpty()){
                ss.pop();
            }
        }else{
            ss.push(i);
        }
      }
    for( char i: t.toCharArray()){
        if(i=='#'){
            if(!tt.isEmpty()){
                tt.pop();
            }
        }else{
            tt.push(i);
        }
      } 
      return ss.equals(tt);
    }
}