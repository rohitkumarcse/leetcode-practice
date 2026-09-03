class Solution {

    public boolean uniformArray(int[] nums1) {

        int n = nums1.length;

        int evenCnt = 0;
        int oddCnt = 0;

        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = -1;

        // Count even and odd + find minimum odd
        for (int i = 0; i < n; i++) {

            if ((nums1[i] & 1) == 0) {
                evenCnt++;
            } else {
                oddCnt++;

                if (nums1[i] < minOdd) {
                    minOdd = nums1[i];
                    minOddIndex = i;
                }
            }
        }

        // All elements are already of same parity
        if (evenCnt == n || oddCnt == n) {
            return true;
        }

        // Subtract minimum odd from every even element
        // except the minimum odd element itself
        for (int i = 0; i < n; i++) {

            if (i != minOddIndex && (nums1[i] & 1) == 0) {

                nums1[i] = nums1[i] - minOdd;

                if (nums1[i] < 1) {
                    return false;
                }
            }
        }

        return true;
    }
}