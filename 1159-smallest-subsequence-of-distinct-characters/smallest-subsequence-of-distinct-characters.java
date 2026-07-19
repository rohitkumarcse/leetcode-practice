class Solution {
    public String smallestSubsequence(String s) {
        Stack<Integer> st = new Stack<>();

        int[] lastIndex = new int[26];
        boolean[] flag = new boolean[26];

        int n = s.length();

        // Store the last occurrence of every character
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            lastIndex[idx] = i;
        }

        int i = 0;

        while (i < n) {
            int idx = s.charAt(i) - 'a';

            // If character is already present, skip it
            if (flag[idx]) {
                i++;
                continue;
            }

            // Remove larger characters if they appear again later
            while (!st.isEmpty()
                    && st.peek() > idx
                    && i < lastIndex[st.peek()]) {

                int removed = st.pop();
                flag[removed] = false;
            }

            flag[idx] = true;
            st.push(idx);

            i++;
        }

        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            result.append((char) (st.remove(0) + 'a'));
        }

        return result.toString();
    }
}