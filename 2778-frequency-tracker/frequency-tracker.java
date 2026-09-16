class FrequencyTracker {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Integer> count;

    public FrequencyTracker() {
        freq = new HashMap<>();
        count = new HashMap<>();
    }

    public void add(int number) {
        int oldFreq = freq.getOrDefault(number, 0);
        if (oldFreq > 0) {
            count.put(oldFreq, count.get(oldFreq) - 1);
        }
        int newFreq = oldFreq + 1;
        freq.put(number, newFreq);
        count.put(newFreq, count.getOrDefault(newFreq, 0) + 1);
    }

    public void deleteOne(int number) {
        int oldFreq = freq.getOrDefault(number, 0);
        if (oldFreq == 0) {
            return;
        }
        count.put(oldFreq, count.get(oldFreq) - 1);
        int newFreq = oldFreq - 1;

        if (newFreq == 0) {
            freq.remove(number);
        } else {
            freq.put(number, newFreq);
            count.put(newFreq, count.getOrDefault(newFreq, 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {

        return count.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */