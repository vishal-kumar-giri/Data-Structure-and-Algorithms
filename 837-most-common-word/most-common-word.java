import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase();
        
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        
        StringBuilder word = new StringBuilder();
        
        for(int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            
            // agar letter hai
            if(Character.isLetter(ch)) {
                word.append(ch);
            } 
            // agar letter nahi hai (space, comma, etc.)
            else {
                if(word.length() > 0) {
                    String w = word.toString();
                    
                    if(!bannedSet.contains(w)) {
                        map.put(w, map.getOrDefault(w, 0) + 1);
                    }
                    
                    word.setLength(0); // reset word
                }
            }
        }
        
        // last word handle karne ke liye
        if(word.length() > 0) {
            String w = word.toString();
            if(!bannedSet.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        
        // max find karo
        String result = "";
        int max = 0;
        
        for(String key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                result = key;
            }
        }
        
        return result;
    }
}