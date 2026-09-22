class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length())
            return ans;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (right - left + 1 > p.length()) {
                char remove = s.charAt(left++);
                window.put(remove, window.get(remove) - 1);
                if (window.get(remove) == 0)
                    window.remove(remove);
            }
            if (window.equals(map))
                ans.add(left);
        }
        return ans;
    }
}