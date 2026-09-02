// class Solution {

//     public boolean uniformArray(int[] nums1) {

//         boolean allEven = true;

//         // for all evens
//         for (int i = 0; i < nums1.length; i++) {

//             if ((nums1[i] & 1) != 0) {

//                 int j = 0;

//                 while (j + 1 < nums1.length &&
//                        ((nums1[i] - nums1[j]) & 1) == 0) {

//                     j++;
//                 }

//                 if (j < nums1.length) {
//                     continue;
//                 } else {
//                     allEven = false;
//                 }
//             }
//         }

//         if (!allEven) {

//             for (int i = 0; i < nums1.length; i++) {

//                 if ((nums1[i] & 1) == 0) {

//                     int j = 0;

//                     while (j + 1 < nums1.length &&
//                            ((nums1[i] - nums1[j]) & 1) != 0) {

//                         j++;
//                     }

//                     if (j < nums1.length) {
//                         continue;
//                     } else {
//                         return false;
//                     }
//                 }
//             }
//         }

//         return true;
//     }
// }

class Solution {

    public boolean uniformArray(int[] nums1) {
        return true;
    }
}