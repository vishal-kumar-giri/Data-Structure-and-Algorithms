class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
      int count = 0;
      int sum = 0;
      for(int i=0;i<k;i++){
        sum +=nums[i];
      } 
      if(sum / k >= threshold) count++;
      
      for(int i=k;i<nums.length;i++){
        sum = sum - nums[i-k]+nums[i];
        if(sum/k>=threshold)count++;
      } 
      return count;
    }
}