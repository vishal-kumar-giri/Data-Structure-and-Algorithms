class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0]- b[0]);
        PriorityQueue <Integer> maxHeap = new PriorityQueue<>(
            (a ,b)-> b - a);
        for(int i=0; i<profit.length; i++){
            minHeap.offer(new int[]{capital[i] , profit[i]});
        }
        while(k > 0){
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= w){
                maxHeap.offer(minHeap.poll()[1]);
            }
            if(maxHeap.isEmpty()){
                break;
            }
            k--;    
            w += maxHeap.poll();
        }
        return w;
    }
}