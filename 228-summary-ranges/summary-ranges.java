class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> ans = new ArrayList<>();
       int n = nums.length;
       if(n==0)return ans;
       int start = nums[0];
       for(int i=0;i<n;i++){
        if(i== n-1 || nums[i]+1 != nums[i+1]){
            if(start == nums[i]){
                ans.add(String.valueOf(start));
            }else{
                ans.add(start+"->"+nums[i]);
            }
            if(i!= n-1){
                start = nums[i+1];
            }
        }
       } 
       return ans;
    }
}