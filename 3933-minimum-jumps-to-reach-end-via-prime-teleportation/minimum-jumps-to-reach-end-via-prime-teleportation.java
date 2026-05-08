class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            int val = nums[i];

            for (int p = 2; p * p <= val; p++) {

                if (val % p == 0) {

                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);

                    while (val % p == 0) {
                        val /= p;
                    }
                }
            }

            if (val > 1) {
                map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[n];

        q.offer(0);

        vis[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) return jumps;
                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }
                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }
                int val = nums[idx];

                if (isPrime(val)) {

                    List<Integer> next = map.getOrDefault(val, new ArrayList<>());

                    for (int ni : next) {

                        if (!vis[ni]) {
                            vis[ni] = true;
                            q.offer(ni);
                        }
                    }
                    map.remove(val);
                }
            }

            jumps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}