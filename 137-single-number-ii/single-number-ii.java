class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int curr = nums[i];
        map.put(curr,map.getOrDefault(curr,0)+1);
      } 
    for(int key : map.keySet()){
        if(map.get(key)==1){
            return key;
        }
    }
    return -1;
    }
}