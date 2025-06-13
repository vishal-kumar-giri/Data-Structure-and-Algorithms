class Solution {
public:
    int missingNumber(vector<int>& nums) {
     int n=nums.size();
     int sum=n*(n+1)/2;
     int curSum=0;
     for(int i=0;i<n;i++){
        curSum =curSum+nums[i];
     }  
     int res=sum-curSum;
     return res;
    }
};