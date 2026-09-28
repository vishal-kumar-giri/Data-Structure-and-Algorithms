class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );
        pq.addAll(map.keySet());
        StringBuilder ans = new StringBuilder();
        Character previous = null;
        while (!pq.isEmpty()) {
            char current = pq.poll();
            ans.append(current);
            map.put(current, map.get(current) - 1);
            if (previous != null && map.get(previous) > 0) {
                pq.offer(previous);
            }
            previous = current;
        }
        if (ans.length() != s.length()) {
            return "";
        }
        return ans.toString();
    }
}