class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer , Integer> map = new HashMap<>();
        for(int num:nums)map.put(num,map.getOrDefault(num,0)+1);
        int val = nums.length/2;
        for(Map.Entry <Integer,Integer>entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value>val)return key;
        }
        return -1;    
    }
}