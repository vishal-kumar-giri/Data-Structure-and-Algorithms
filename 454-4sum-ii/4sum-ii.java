class Solution {

    public int fourSumCount(int[] nums1, int[] nums2,
                            int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // nums1 + nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // nums3 + nums4
        for (int c : nums3) {
            for (int d : nums4) {

                int required = -(c + d);

                count += map.getOrDefault(required, 0);
            }
        }

        return count;
    }
}