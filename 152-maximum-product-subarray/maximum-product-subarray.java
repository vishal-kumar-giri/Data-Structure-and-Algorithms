class Solution {
    public int maxProduct(int[] nums) {
       int maxPro = nums[0];
       int minPro = nums[0];
       int ans = nums[0];
       for(int i= 1;i<nums.length;i++){
        int curr = nums[i];
        if(curr<0){
            int temp = maxPro;
            maxPro = minPro;
            minPro = temp;
        }
        maxPro = Math.max(curr,curr*maxPro);
        minPro = Math.min(curr,curr*minPro);
        ans = Math.max(ans, maxPro);
       } 
       return ans;
    }
}