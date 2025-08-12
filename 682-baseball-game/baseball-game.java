class Solution {
    public int calPoints(String[] operations) {
      Stack<Integer>st=new Stack<>();
      for(String op:operations){
        switch(op){
            case "+":
                int top=st.pop();
                int newScore=top+st.peek();
                st.push(top);
                st.push(newScore);
                break;
            case "D":
            st.push(st.peek()*2);
            break;
            case "C":
            st.pop();
            break;
            default:
            st.push(Integer.parseInt(op));
            break;
        }
      }  
      int totalScore=0;
      for(int score:st){
        totalScore+=score;
      }
      return totalScore;
    }
}