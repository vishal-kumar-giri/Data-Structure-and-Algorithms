class Solution {
    public int minSwaps(int[] nums) {
        int window = 0;
        for(int num:nums){
            window += num;
        }
        int curZero = 0;
        for(int i=0; i<window; i++){
            if(nums[i] == 0)curZero++;
        }
        int minZero = curZero;
        int n = nums.length;
        int si = 0; int ei = window-1;
        while(si<n){
            if(nums[si] == 0){
                curZero--;
            }
            si++;
            ei++;
            if(nums[ei%n] == 0){
                curZero++;
            }
            minZero = Math.min(curZero,minZero);
        }
        return minZero;
    }
}