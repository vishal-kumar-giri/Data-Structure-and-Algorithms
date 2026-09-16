class Solution {
    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            int left = i;
            int mid = j - i;
            int right = n - j;
            ans += left * mid * right;
            i = j;
        }
        return ans;
    }
}