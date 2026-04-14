class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res[] = new int [m+n];
        int i = 0;
        int j = 0;
        int x = 0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[x++] = nums1[i++];
            }else{
                res[x++] = nums2[j++];
            }
        }
        while(i!=m)res[x++] = nums1[i++];
        while(j!=n)res[x++] = nums2[j++];
        int len = res.length;
        if(len%2==0){
            return (res[len/2]+res[len/2-1])/2.0;
        }else{
            return res[len/2];
        }
    }
}