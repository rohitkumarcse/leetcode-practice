class Solution {
    public int maxProduct(int n) {
        int largestDigit = 0;
        int secondLargestDigit = 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            if (digit >= largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digit;
            } else if (digit > secondLargestDigit) {
                secondLargestDigit = digit;
            }
        }

        return largestDigit * secondLargestDigit;
    }
}