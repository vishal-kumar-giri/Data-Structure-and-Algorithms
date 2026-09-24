class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int si = 1;
        int ei = position[n - 1] - position[0];
        int ans = 0;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (isAllocationPossible(mid, position, m)) {
                ans = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return ans;
    }

    public boolean isAllocationPossible(int mid, int[] position, int m) {
        int ballPlaced = 1;
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                ballPlaced++;
                last = position[i];
                if (ballPlaced >= m) {
                    return true;
                }
            }
        }
        return false;
    }
}