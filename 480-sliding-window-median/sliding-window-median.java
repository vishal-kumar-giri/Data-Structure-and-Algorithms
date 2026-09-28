class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> small =
                new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> large =
                new PriorityQueue<>();

        HashMap<Integer, Integer> delayed = new HashMap<>();

        int smallSize = 0;
        int largeSize = 0;

        double[] ans = new double[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {

            if (small.isEmpty() || nums[i] <= small.peek()) {
                small.offer(nums[i]);
                smallSize++;
            } else {
                large.offer(nums[i]);
                largeSize++;
            }

            // Balance
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                smallSize--;
                largeSize++;
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
            }
        }

        ans[0] = getMedian(small, large, k);

        // Sliding window
        for (int i = k; i < nums.length; i++) {

            int in = nums[i];
            int out = nums[i - k];

            // Add new element
            if (in <= small.peek()) {
                small.offer(in);
                smallSize++;
            } else {
                large.offer(in);
                largeSize++;
            }

            // Mark outgoing element for deletion
            delayed.put(
                    out,
                    delayed.getOrDefault(out, 0) + 1
            );

            // Decide which heap's logical size decreases
            if (out <= small.peek()) {
                smallSize--;
            } else {
                largeSize--;
            }

            // Remove invalid top elements
            prune(small, delayed);
            prune(large, delayed);

            // Balance heaps
            if (smallSize > largeSize + 1) {

                large.offer(small.poll());

                smallSize--;
                largeSize++;

                prune(small, delayed);

            } else if (smallSize < largeSize) {

                small.offer(large.poll());

                largeSize--;
                smallSize++;

                prune(large, delayed);
            }

            ans[i - k + 1] =
                    getMedian(small, large, k);
        }

        return ans;
    }

    private void prune(
            PriorityQueue<Integer> heap,
            HashMap<Integer, Integer> delayed) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (!delayed.containsKey(num)) {
                break;
            }

            int count = delayed.get(num);

            if (count == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, count - 1);
            }

            heap.poll();
        }
    }

    private double getMedian(
            PriorityQueue<Integer> small,
            PriorityQueue<Integer> large,
            int k) {

        if (k % 2 == 1) {

            return small.peek();

        } else {

            return ((long) small.peek()
                    + (long) large.peek()) / 2.0;
        }
    }
}