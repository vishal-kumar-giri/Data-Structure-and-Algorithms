import java.util.*;

class Solution {
    public boolean equalFrequency(String word) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Frequency count
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Har character ko remove karke check
        for (char ch : map.keySet()) {

            map.put(ch, map.get(ch) - 1);

            if (check(map)) {
                return true;
            }

            // Restore
            map.put(ch, map.get(ch) + 1);
        }

        return false;
    }

    private boolean check(HashMap<Character, Integer> map) {

        int frequency = 0;

        for (int value : map.values()) {

            if (value == 0) {
                continue;
            }

            if (frequency == 0) {
                frequency = value;
            } 
            else if (frequency != value) {
                return false;
            }
        }

        return true;
    }
}