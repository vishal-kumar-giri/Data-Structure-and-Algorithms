class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
      solve("",0,0,n,ans);
      return ans;  
    }
    public  void solve(String str , int open , int close, int total,List<String>ans){
        if (str.length() == 2 * total) {
            ans.add(str);
            return;
        }
        if (open < total) {
            solve(str + "(", open + 1, close, total, ans);
        }
        if (close < open) {
            solve(str + ")", open, close + 1, total, ans);
        }
        }
    }
