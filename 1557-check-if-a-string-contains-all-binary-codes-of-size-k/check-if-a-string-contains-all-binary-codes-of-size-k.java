class Solution {
    public boolean hasAllCodes(String s, int k) {

        int n = s.length();
        HashSet<String> hset = new HashSet<>();
        int totalCode = 1 << k;

        // 2^k possible binary numbers of length k
        for (int i = k; i <= n; i++) {
            String sub = s.substring(i - k, i);

            if (!hset.contains(sub)) {
                hset.add(sub);
                totalCode--;
            }

            if (totalCode == 0)
                return true;
        }

        return false;
    }
}