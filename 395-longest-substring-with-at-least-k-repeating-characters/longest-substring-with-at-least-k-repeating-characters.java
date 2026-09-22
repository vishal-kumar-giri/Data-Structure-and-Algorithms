class Solution {
    public int longestSubstring(String s, int k) {

        int ans = 0;

        for (int unique = 1; unique <= 26; unique++) {

            HashMap<Character, Integer> map = new HashMap<>();

            int left = 0;
            int right = 0;
            int uniqueCount = 0;
            int countAtLeastK = 0;

            while (right < s.length()) {

                char ch = s.charAt(right++);

                if (!map.containsKey(ch))
                    uniqueCount++;

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) == k)
                    countAtLeastK++;

                while (uniqueCount > unique) {

                    char c = s.charAt(left++);

                    if (map.get(c) == k)
                        countAtLeastK--;

                    map.put(c, map.get(c) - 1);

                    if (map.get(c) == 0) {
                        map.remove(c);
                        uniqueCount--;
                    }
                }

                if (uniqueCount == unique &&
                    uniqueCount == countAtLeastK) {
                    ans = Math.max(ans, right - left);
                }
            }
        }

        return ans;
    }
}