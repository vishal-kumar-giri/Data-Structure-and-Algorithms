class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            set.add(sum);
            left++;
            right--;
        }
        return set.size();
    }
}