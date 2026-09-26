class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++; 
                StringBuilder key = new StringBuilder();
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }
                i++;
                String value = map.getOrDefault(key.toString(), "?");
                ans.append(value);
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}