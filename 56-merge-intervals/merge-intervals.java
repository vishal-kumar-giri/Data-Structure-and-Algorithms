class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals , (a,b)->Integer.compare(a[0],b[0]));
       Stack<int[]> stack = new Stack<>();
       stack.push(intervals[0]);
       for(int i=1;i<intervals.length;i++){
        int startPoint2 = intervals[i][0];
        int endPoint2 = intervals[i][1];
        int[] popArray = stack.pop();
        int startPoint1 = popArray[0];
        int endPoint1 = popArray[1]; 
        int endMax = Math.max(endPoint2,endPoint1);
        if(endPoint1>=startPoint2){
            int merge[] = new int[]{startPoint1,endMax};
            stack.push(merge);
        }else{
            stack.push(popArray);
            stack.push(intervals[i]);
        }
       } 
       int [][] output = new int[stack.size()][2];
       for(int i = output.length-1;i>=0;i--){
            int[] popArray = stack.pop();
            output[i][0] = popArray[0];
            output[i][1] = popArray[1];
       }
       return output;
    }
}