import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Step 1: frequency count
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Step 2: follow order string
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                
                while(freq > 0){
                    sb.append(ch);
                    freq--;
                }
                
                map.remove(ch);
            }
        }
        
        // Step 3: remaining characters
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            
            while(freq > 0){
                sb.append(ch);
                freq--;
            }
        }
        
        return sb.toString();
    }
}