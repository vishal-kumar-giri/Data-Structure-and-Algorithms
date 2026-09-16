class Solution {
    public int similarPairs(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int mask = 0;
            for (char ch : word.toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            ans += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
}