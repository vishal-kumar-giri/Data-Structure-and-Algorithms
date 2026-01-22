class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int n = nums.length , res = 0 , ans = Integer.MAX_VALUE , left = 0;
       for(int i=0;i<n;i++){
        res += nums[i];
        while(res>=target){
            ans = Math.min(ans,i-left+1);
            res -= nums[left++];
          }
       }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}