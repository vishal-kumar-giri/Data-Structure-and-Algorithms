class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer>map = new HashMap<>();
       for(int i=0;i<nums.length;i++)map.put(nums[i],i);
       for(int i=0;i<nums.length;i++){
        int num=nums[i];
        int rem = target - num;
        if(map.containsKey(rem)){
            int idx = map.get(rem);
            if(idx==i)continue;
            return new int[]{i,idx};
        }
       } 
       return new int[]{};
    }
}