class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Check all 32 bit positions of an integer
        for (int i = 0; i < 32; i++) {

            // Create a mask with only the i-th bit set
            //
            // i = 0 → 0001
            // i = 1 → 0010
            // i = 2 → 0100
            //
            int temp = (1 << i);

            // Count how many numbers have the i-th bit set
            int cntOnes = 0;

            for (int num : nums) {

                // If the i-th bit of num is set,
                // (num & temp) will be non-zero
                //
                // Example:
                // num  = 4  → 0100
                // temp = 4  → 0100
                //
                // 0100
                // &0100
                // ------
                // 0100 → 4 (non-zero)
                //
                if ((num & temp) != 0) {
                    cntOnes++;
                }
            }

            // Every number that appears 3 times
            // contributes its bit 3 times.
            //
            // Therefore:
            //
            // 3 % 3 = 0 → repeated number's bit disappears
            // 1 % 3 = 1 → unique number's bit remains
            //
            if (cntOnes % 3 == 1) {

                // Set the i-th bit in result
                result = result | temp;
            }
        }

        return result;
    }
}