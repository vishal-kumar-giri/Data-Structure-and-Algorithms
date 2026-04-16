class Solution {
    public String simplifyPath(String path) {
     String str[] = path.split("/");
     Stack<String> st = new Stack<>();
     for(String i : str){
        if(i.equals("..") && !st.isEmpty()){
            st.pop();
        }else if(!i.equals("") && !i.equals(".") && !i.equals("..")){
            st.push(i);
        }
     } 
     StringBuilder sb = new StringBuilder();
     for(String j : st){
        sb.append("/");
        sb.append(j);
     }
    return sb.length()==0?"/":sb.toString();
    }
}