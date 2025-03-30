class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Count occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Check which numbers are majority elements
        int threshold = nums.length / 3;
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) > threshold) {
                result.add(key);
            }
        }
        
        return result;
    }
}