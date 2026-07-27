class Solution {
    static int result;

    public int maxLength(List<String> arr) {
        result = 0;

        List<Integer> uniqueStrings = new ArrayList<>();

        for (String str : arr) {
            Set<Character> set = new HashSet<>();

            for (char ch : str.toCharArray()) {
                set.add(ch);
            }

            // Contains duplicate characters
            if (set.size() != str.length()) {
                continue;
            }

            int val = 0;

            for (char ch : str.toCharArray()) {
                val = val | (1 << (ch - 'a'));
            }

            uniqueStrings.add(val);
        }

        int temp = 0;

        solve(0, temp, uniqueStrings);

        return result;
    }

    public static void solve(int idx, int temp, List<Integer> uniqueStrings) {
        result = Math.max(result, Integer.bitCount(temp));

        for (int i = idx; i < uniqueStrings.size(); i++) {
            if ((temp & uniqueStrings.get(i)) == 0) {
                solve(
                    i + 1,
                    temp | uniqueStrings.get(i),
                    uniqueStrings
                );
            }
        }
    }
}