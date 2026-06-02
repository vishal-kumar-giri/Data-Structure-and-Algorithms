class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap <Integer , Integer> map = new HashMap<>();
        for(int num : nums)map.put(num , map.getOrDefault(num , 0)+1);
        List <Integer> list = new ArrayList<>();
        for(Map.Entry<Integer ,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();
            if(freq >= 2){
                list.add(key);
            }
        }
        return list;    
    }
}