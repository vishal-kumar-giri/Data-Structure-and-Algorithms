class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] suffix = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            set.add(nums[i]);
            suffix[i] = set.size();
        }
        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            int leftDistinct = set.size();
            int rightDistinct = (i + 1 < n) ? suffix[i + 1] : 0;
            ans[i] = leftDistinct - rightDistinct;
        }
        return ans;
    }
}