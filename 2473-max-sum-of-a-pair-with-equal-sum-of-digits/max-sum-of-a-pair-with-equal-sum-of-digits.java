class Solution {
    public int maximumSum(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int ans = -1;
       for(int num:nums){
        int digitSum = DigitSum(num);
        if(map.containsKey(digitSum)){
          int prev = map.get(digitSum);
          ans = Math.max(prev+num,ans);
          map.put(digitSum,Math.max(prev,num));  
        }else{
            map.put(digitSum,num);
        }
       } 
       return ans;
    }
    public int DigitSum(int num){
        int sum = 0;
        while(num>0){
            int rem = num%10;
            sum +=rem;
            num = num/10;
        }
        return sum;
    }
}