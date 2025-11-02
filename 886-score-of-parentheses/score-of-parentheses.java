class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(char i : s.toCharArray()){
            if(i=='('){
                st.push(0);
            }else{
                int v = st.pop();
                int w = st.pop();
                st.push(w + Math.max(2*v,1));
            }
        }
        return st.pop();
    }
}