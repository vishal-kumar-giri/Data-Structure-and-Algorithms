// class Solution {
//     public int majorityElement(int[] nums) {
//       HashMap<Integer,Integer> map = new HashMap<>();
//       for(int num : nums)map.put(num,map.getOrDefault(num,0)+1);
//       int ans = nums.length/2;
//       for(int num:nums){
//         if(map.get(num)>ans){
//             return num;
//         }
//       }  
//       return -1;
//     }
// }
 class Solution{
    public int majorityElement(int[] nums){
        int ans = 0; 
        int freq = 0;
        for(int i=0;i<nums.length;i++){
            if(freq==0)ans = nums[i];
            if(ans == nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
        return ans;
    }
 }