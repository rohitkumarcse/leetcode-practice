//------------------------------------------- Approach -1 -------------------------------------

// class Solution {
//     public int[] sortByBits(int[] arr) {
//         int n = arr.length;
//         int[][] res = new int[n][2];

//         for (int i = 0; i < arr.length; i++) {
//             res[i][0] = arr[i];
//             res[i][1] = countOnes(arr[i]);
//         }

//         Arrays.sort(res, (a, b) -> {
//             if (a[1] == b[1]) {
//                 return a[0] - b[0];
//             }
//             return a[1] - b[1];
//         });

//         int[] ans = new int[n];

//         for (int i = 0; i < n; i++) {
//             ans[i] = res[i][0];
//         }

//         return ans;
//     }

//     public int countOnes(int n) {
//         int count = 0;

//         while (n != 0) {
//             n = n & (n - 1);
//             count++;
//         }

//         return count;
//     }
// }

// -------------------------------------------- Approach -2 -------------------
class Solution {
    public int[] sortByBits(int[] arr) {
        int[] bin = new int[10001];

        for (int i = 1; i < 10001; i++) {
            if (i % 2 == 0) {
                bin[i] = bin[i / 2];
            } else {
                bin[i] = bin[i / 2] + 1;
            }
        }

        Integer[] nums = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            if (bin[a] == bin[b]) {
                return a - b;
            }

            return bin[a] - bin[b];
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}