class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0;i<k;i++){
            curr += nums[i];
        }
        maxSum = curr;
        for(int i=k;i<nums.length;i++){
            curr = curr-nums[i-k]+nums[i];
            maxSum = Math.max(curr,maxSum);
        }
        return (double)maxSum/k;
    }
}