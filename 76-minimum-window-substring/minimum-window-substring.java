class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Step 1: store frequency of t
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int count = map.size(); // unique characters to match
        
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while(right < s.length()){
            char ch = s.charAt(right);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                
                if(map.get(ch) == 0){
                    count--;
                }
            }
            
            // window valid hai
            while(count == 0){
                
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) + 1);
                    
                    if(map.get(leftChar) > 0){
                        count++;
                    }
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}