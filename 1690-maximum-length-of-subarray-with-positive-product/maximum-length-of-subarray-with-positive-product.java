class Solution {
    public int getMaxLen(int[] nums) {
        int pos = 0 , neg = 0 , ans = 0;
        for(int num : nums){
            if(num == 0){
                pos = 0;
                neg = 0;
            }else if(num > 0){
                pos++;
                if(neg>0)neg++;
            }else{
                int temp = pos;
                pos = (neg>0)? neg+1 : 0;
                neg = temp + 1;
            }
            ans = Math.max(pos,ans);
        }   
        return ans;
    }
}