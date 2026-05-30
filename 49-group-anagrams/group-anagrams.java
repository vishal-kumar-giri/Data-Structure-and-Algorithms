class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String , List<String>> map = new HashMap<>();
        for(String str:strs){
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            String newStr = new String(ch);
            if(!map.containsKey(newStr)){
                map.put(newStr,new ArrayList<>());
            }
            map.get(newStr).add(str);
            
        } 
        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()){
            res.add(list);
        }   
        return res;
    }
}