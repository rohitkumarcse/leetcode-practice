class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int vector[] = new int[32];
        // vector[i] = total number of set bits at i-th bit

        while (j < n) {
            addNumberWindow(nums[j], vector);

            while (i <= j && getDecimalNumber(vector) >= k) {
                result = Math.min(result, j - i + 1);
                removeFromWindow(nums[i], vector);
                i++;
            }
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void addNumberWindow(int number, int vector[]) {
        for (int i = 0; i < 32; i++) {
            if (((number >> i) & 1) == 1) {
                vector[i]++;
            }
        }
    }

    public static void removeFromWindow(int number, int vector[]) {
        for (int i = 0; i < 32; i++) {
            if (((number >> i) & 1) == 1) {
                if (vector[i] > 0) {
                    vector[i]--;
                }
            }
        }
    }

    public static int getDecimalNumber(int[] vector) {
        int num = 0;

        for (int i = 0; i < 32; i++) {
            if (vector[i] > 0) {
                num |= 1 << i;
            }
        }

        return num;
    }
}