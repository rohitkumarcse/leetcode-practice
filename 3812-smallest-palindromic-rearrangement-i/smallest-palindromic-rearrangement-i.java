// import java.util.Arrays;

// class Solution {
//     public String smallestPalindrome(String s) {
//         int n = s.length();
//         int mid = n / 2;

//         char[] arr = s.toCharArray();

//         Arrays.sort(arr, 0, mid);

//         for (int i = 0; i < mid; i++) {
//             arr[n - 1 - i] = arr[i];
//         }

//         return new String(arr);
//     }
// }
// ----------------------------------------------- Approach -2 -------------------
class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder first = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                first.append((char) ('a' + i));
                freq[i] -= 2;
            }

            if (freq[i] == 1 && mid.length() == 0) {
                mid.append((char) ('a' + i));
            }
        }

        StringBuilder second = new StringBuilder(first).reverse();

        return first.toString() + mid.toString() + second.toString();
    }
}