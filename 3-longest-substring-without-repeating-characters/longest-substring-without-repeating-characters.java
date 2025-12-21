class Solution {
    public int lengthOfLongestSubstring(String str) {
        int left = 0 , right = 0;
        int [] nums = new int[256];
        int maxLength = 0;
        while(right<str.length()){
            int curChar = str.charAt(right);
            int curCharValue = (int) curChar;
            nums[curCharValue] = nums[curCharValue]+1;
            while(nums[curCharValue]>1){
                char leftChar = str.charAt(left);
                int leftCharValue = (int) leftChar;
                nums[leftCharValue] = nums[leftCharValue]-1;
                left++;
            }
            int curWindowSize = right-left + 1;
            if(curWindowSize>maxLength)maxLength = curWindowSize;
            right++;
        }
        return maxLength;
    }
}