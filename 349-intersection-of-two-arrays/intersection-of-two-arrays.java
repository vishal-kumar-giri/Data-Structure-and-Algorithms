class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int num:nums1)set.add(num);
        for(int ans:nums2){
            if(set.contains(ans))res.add(ans);
        }
        int [] arr = new int[res.size()];
        int idx = 0;
        for(int num: res){
            arr[idx++] = num;
        }
        return arr; 
    }
}