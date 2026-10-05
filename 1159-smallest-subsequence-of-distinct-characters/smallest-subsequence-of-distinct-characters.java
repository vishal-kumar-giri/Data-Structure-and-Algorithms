class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        HashSet<Character> used = new HashSet<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.get(ch) - 1);
            if (used.contains(ch)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) > 0) {
                char removed = stack.pop();
                used.remove(removed);
            }
            stack.push(ch);
            used.add(ch);
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }
        return ans.toString();
    }
}