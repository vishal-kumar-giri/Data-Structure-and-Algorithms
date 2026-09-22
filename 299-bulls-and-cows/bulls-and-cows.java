class Solution {
    public String getHint(String secret, String guess) {

        HashMap<Character, Integer> map = new HashMap<>();
        int bulls = 0, cows = 0;

        // Store unmatched secret digits
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        // Find cows
        for (int i = 0; i < guess.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s != g && map.getOrDefault(g, 0) > 0) {
                cows++;
                map.put(g, map.get(g) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}