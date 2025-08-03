import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int[]ps= previousSmaller(heights);
        int[]ns= nextSmaller(heights);
        for(int i=0;i<heights.length;i++){
            int width=ns[i]-ps[i]-1;
            int curr=width*heights[i];
            maxArea=Math.max(maxArea,curr);
        }
        return maxArea;
    }
    public static int[] previousSmaller(int nums[]){
        Stack<Integer>st=new Stack<>();
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            result[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return result;
    }
    public static int[] nextSmaller(int nums[]){
        Stack<Integer>st=new Stack<>();
        int result[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            result[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        return result;
    }
}