class Solution {

    String s;
    int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> set = parseExpression();

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }

    // expression = term (',' term)*
    private Set<String> parseExpression() {

        Set<String> result = new HashSet<>();

        result.addAll(parseTerm());

        while (index < s.length() && s.charAt(index) == ',') {

            index++; // skip ','

            result.addAll(parseTerm());
        }

        return result;
    }

    // term = factor factor factor...
    private Set<String> parseTerm() {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> current = parseFactor();

            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }

    private Set<String> parseFactor() {

        Set<String> result = new HashSet<>();

        char ch = s.charAt(index);

        if (ch == '{') {

            index++; // skip {

            result = parseExpression();

            index++; // skip }

        } else {

            result.add(String.valueOf(ch));

            index++;
        }

        return result;
    }
}