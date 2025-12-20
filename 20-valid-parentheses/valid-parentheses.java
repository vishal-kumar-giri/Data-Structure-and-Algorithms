class Solution {
    public boolean isValid(String str) {
       if(str.length()%2!=0)return false;
       Stack<Character> st = new Stack<>();
       for(int i= 0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch=='(' || ch=='{' || ch=='['){
            st.push(ch);
        }else{
            if(st.isEmpty())return false;
            char top = st.peek();
            if(ch==')' && top!='('){
                return false;
            }else if(ch=='}' && top!='{'){
                return false;
            }else if(ch==']' && top!='['){
                return false;
            }else{
                st.pop();
            }
        }
       }
       if(!st.isEmpty())return false;
       return true; 
    }
}