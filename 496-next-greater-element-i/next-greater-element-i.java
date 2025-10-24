class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     int res[] = new int[nums1.length];
     int count=0;
     for(int i=0;i<nums1.length;i++){
        int curr = nums1[i];
        int next =-1;
        boolean found = false;
        for(int j=0;j<nums2.length;j++){
            if(curr == nums2[j]){
                found = true;
            }
            if(found && nums2[j]>curr){
                next = nums2[j];
                break;
            }
        }
        res[count] = next;
        count++;
     }
     for(int i=0;i<res.length;i++)nums1[i] = res[i];
     return nums1;      
    }
}