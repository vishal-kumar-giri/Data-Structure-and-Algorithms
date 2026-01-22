class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reversed(nums,0,n-1);
        reversed(nums,0,k-1);
        reversed(nums,k,n-1);
    }
    public void reversed(int[]nums, int si , int ei){
        while(si<=ei){
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            si++;
            ei--;
        }
    }
}