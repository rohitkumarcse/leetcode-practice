// ---------------------------------- Approach - 1 -------------------------------------------

// class Solution {
//     public int numSteps(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         int steps = 0;

//         while (!(sb.length() == 1 && sb.charAt(0) == '1')) {

//             if (sb.charAt(sb.length() - 1) == '0') {
//                 // divide by 2
//                 sb.deleteCharAt(sb.length() - 1);
//                      steps++;
//             } else {
//                 // add 1
//                 addOne(sb);
//                 steps+=2;
//             }

       
//         }

//         return steps;
//     }

//     private void addOne(StringBuilder sb) {
//         int i = sb.length() - 1;

//         while (i >= 0 && sb.charAt(i) == '1') {
//             sb.deleteCharAt(sb.length() - 1);
//             i--;
//         }

//         if (i >= 0) {
//             sb.setCharAt(i, '1');
//         } else {
//             sb.insert(0, '1');
//         }
//     }
// }

// ---------------------------------- Approach - 2 -------------------------------------------

class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        int carry =0;
        int n = s.length();

        for( int i = n-1; i>=1 ; i-- ){
            if( ((s.charAt(i)-'0')+carry)%2 == 1){ // odd
                 steps+=2;
                 carry =1;
            }else{
                steps+=1;
            }
        }
        return steps + carry;
    }

}