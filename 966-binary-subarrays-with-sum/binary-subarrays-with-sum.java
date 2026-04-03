class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return numSubArray(nums,goal)-numSubArray(nums,goal-1); 
    }
    public int numSubArray(int nums[],int goal){
        int start = 0;
        int sum = 0;
        int count = 0;
        for(int end = 0;end<nums.length;end++){
            // expand
            sum +=nums[end];
            // shrinking
            while(start<=end && sum>goal){
                sum -=nums[start];
                start++;
            }
            count += (end-start+1);
        }
        return count;
    }
}