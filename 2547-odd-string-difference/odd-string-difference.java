class Solution {
    public String oddString(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String key = getDifference(word);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (String word : words) {
            String key = getDifference(word);
            if (map.get(key) == 1) {
                return word;
            }
        }
        return "";
    }

    public String getDifference(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            int diff = word.charAt(i) - word.charAt(i - 1);
            sb.append(diff).append("#");
        }
        return sb.toString();
    }
}