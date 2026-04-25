class Solution {
    public int findDuplicate(int[] nums) {
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int num:nums)map.put(num,map.getOrDefault(num,0)+1);
      for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        int key = entry.getKey();
        int freq = entry.getValue();
        if(freq>=2)return key;
      }
      return -1;  
    }
}