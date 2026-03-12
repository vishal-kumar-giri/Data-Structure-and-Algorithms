class Solution {
    public int majorityElement(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int num : nums)map.put(num,map.getOrDefault(num,0)+1);
      int ans = nums.length/2;
      for(int num:nums){
        if(map.get(num)>ans){
            return num;
        }
      }  
      return -1;
    }
}