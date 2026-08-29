class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            if (ones == k) {

                int i = left;

                while (i <= right && s.charAt(i) == '0') {

                    String sub = s.substring(i, right + 1);

                    if (ans.equals("")
                            || sub.length() < ans.length()
                            || (sub.length() == ans.length()
                                && sub.compareTo(ans) < 0)) {

                        ans = sub;
                    }

                    i++;
                }

                if (i <= right) {

                    String sub = s.substring(i, right + 1);

                    if (ans.equals("")
                            || sub.length() < ans.length()
                            || (sub.length() == ans.length()
                                && sub.compareTo(ans) < 0)) {

                        ans = sub;
                    }
                }
            }
        }

        return ans;
    }
}