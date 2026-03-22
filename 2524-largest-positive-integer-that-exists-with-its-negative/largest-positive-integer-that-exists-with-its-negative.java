class Solution {
    public int findMaxK(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      int max = -1;
      for(int num:nums){
        if(Math.abs(num)>max){
        if(set.contains(-num)){
            max = Math.abs(num);
        }else{
            set.add(num);
        }
      }
      } 
      return max; 
    }
}