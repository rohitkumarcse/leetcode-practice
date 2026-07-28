//----------------------------------- Approach -1 --------------------------------------------
// class Solution {
//     public int rangeBitwiseAnd(int left, int right) {
//         int bitareDifferent  = 0;

//         while( left != right ){
//             left = (left >> 1);
//             right = (right >> 1);
//             bitareDifferent++;
//         }
//         return (left << bitareDifferent);
//     }
// }


//----------------------------------- Approach -2 --------------------------------------------
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
         while( right > left ){
            right = ( right & ( right -1 ));
         }
         return right;
    }
}