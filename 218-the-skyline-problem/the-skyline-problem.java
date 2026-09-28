class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            events.add(new int[]{left, -height});
            events.add(new int[]{right, height});
        }
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int previousMax = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int[] event : events) {
            int x = event[0];
            int height = event[1];
            if (height < 0) {
                pq.add(-height);
            }
            else {
                pq.remove(height);
            }
            int currentMax = pq.peek();
            if (currentMax != previousMax) {
                result.add(Arrays.asList(x, currentMax));
                previousMax = currentMax;
            }
        }
        return result;
    }
}