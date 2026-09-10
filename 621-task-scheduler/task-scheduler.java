import java.util.*;
class Task implements Comparable<Task>{
    int frequency;
    int executionTime;
    Task(int f, int t){
        frequency = f;
        executionTime = t;
    }
    public int compareTo(Task that){
        return that.frequency - this.frequency;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(char ch: tasks){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(Character ch : freqMap.keySet()){
            int freq = freqMap.get(ch);
            pq.offer(new Task(freq,0));
        }
        Queue<Task> queue = new LinkedList<>();
        int time=0;
        while(!queue.isEmpty() || !pq.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.frequency--;
                if(task.frequency>0){
                    task.executionTime = time + n;
                    queue.offer(task);
                }
            }
            if(!queue.isEmpty() && queue.peek().executionTime == time){
                pq.offer(queue.poll());
            }           
        }
        return time;
    }
}