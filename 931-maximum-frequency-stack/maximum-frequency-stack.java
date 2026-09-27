class FreqStack {
    HashMap<Integer ,Integer> map ;
    HashMap<Integer , Stack<Integer>>group;
    int maxFreq ;
    public FreqStack() {
        map = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val , 0) + 1;
        map.put(val , freq);
        maxFreq = Math.max(freq , maxFreq);
        group.putIfAbsent(freq , new Stack<>());
        group.get(freq).push(val);
    }
    
    public int pop() {
       Stack<Integer>stack =group.get(maxFreq);
       int val = stack.pop();
       map.put(val , map.get(val) - 1);
       if (stack.isEmpty()) {
           group.remove(maxFreq);
            maxFreq--;
        }
        return val; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */