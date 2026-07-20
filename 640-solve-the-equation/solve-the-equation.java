class Solution {

    public String solveEquation(String equation) {

        String[] parts = equation.split("=");

        int[] left = parse(parts[0]);
        int[] right = parse(parts[1]);

        int coeff = left[0] - right[0];
        int constant = right[1] - left[1];

        if (coeff == 0 && constant == 0)
            return "Infinite solutions";

        if (coeff == 0)
            return "No solution";

        return "x=" + (constant / coeff);
    }

    private int[] parse(String s) {

        int coeff = 0;
        int constant = 0;

        int i = 0;
        int sign = 1;

        while (i < s.length()) {

            if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNumber = false;

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                hasNumber = true;
                i++;
            }

            if (i < s.length() && s.charAt(i) == 'x') {

                if (!hasNumber)
                    num = 1;

                coeff += sign * num;
                i++;

            } else {

                constant += sign * num;
            }
        }

        return new int[]{coeff, constant};
    }
}