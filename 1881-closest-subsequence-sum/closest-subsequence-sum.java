class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int n1 = n / 2;
        int n2 = n - n1;

        int subsetA[] = new int[1 << n1];

        for (int mask = 0; mask < (1 << n1); mask++) {
            int sum = 0;

            for (int i = 0; i < n1; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                }
            }

            subsetA[mask] = sum;
        }

        int subsetB[] = new int[1 << n2];

        for (int mask = 0; mask < (1 << n2); mask++) {
            int sum = 0;

            for (int i = 0; i < n2; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[n1 + i];
                }
            }

            subsetB[mask] = sum;
        }

        Arrays.sort(subsetB);

        int minVal = Integer.MAX_VALUE;

        for (int setA : subsetA) {
            int remaining = goal - setA;
            int low = lowerBound(remaining, subsetB);

            if (low < subsetB.length) {
                int total = setA + subsetB[low];
                minVal = Math.min(minVal, Math.abs(total - goal));
            }

            if (low > 0) {
                int total = setA + subsetB[low - 1];
                minVal = Math.min(minVal, Math.abs(total - goal));
            }
        }

        return minVal;
    }

    public int lowerBound(int target, int[] arr) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}