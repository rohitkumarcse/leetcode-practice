class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;

        while (!(sb.length() == 1 && sb.charAt(0) == '1')) {

            if (sb.charAt(sb.length() - 1) == '0') {
                // divide by 2
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // add 1
                addOne(sb);
            }

            steps++;
        }

        return steps;
    }

    private void addOne(StringBuilder sb) {
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) == '1') {
            sb.setCharAt(i, '0');
            i--;
        }

        if (i >= 0) {
            sb.setCharAt(i, '1');
        } else {
            sb.insert(0, '1');
        }
    }
}