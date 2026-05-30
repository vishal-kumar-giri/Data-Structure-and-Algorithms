class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) return new int[]{};
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                int idx = map.get(val);
                if(idx == i)continue;
                return new int[]{i,idx};
            }
        }
        return new int[]{};
    }
}