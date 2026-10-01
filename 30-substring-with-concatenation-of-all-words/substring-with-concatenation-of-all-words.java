class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        if (s.length() < totalLength) {
            return result;
        }
        HashMap<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        for (int offset = 0;
             offset < wordLength;
             offset++) {
            int left = offset;
            int right = offset;
            int count = 0;
            HashMap<String, Integer> windowFreq = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (!wordFreq.containsKey(word)) {
                    windowFreq.clear();
                    count = 0;
                    left = right;
                    continue;
                }
                windowFreq.put(word, windowFreq.getOrDefault(word, 0) + 1);
                count++;
                while (windowFreq.get(word) > wordFreq.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);
                    windowFreq.put(leftWord,windowFreq.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
                if (count == wordCount) {
                    result.add(left);
                    String leftWord = s.substring(left , left + wordLength);
                    windowFreq.put(leftWord , windowFreq.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }
            }
        }
        return result;
    }
}