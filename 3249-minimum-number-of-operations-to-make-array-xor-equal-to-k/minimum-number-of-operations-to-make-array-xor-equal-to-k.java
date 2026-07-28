class Solution {
    public int minOperations(int[] nums, int k) {
      int xor =0;
      for( int i=0; i<nums.length; i++ ){
         xor = (xor ^ nums[i]);
      }
      xor = ( xor ^ k );
      int minCnt =0;
      while( xor > 0 ){
        xor = (xor & ( xor -1));
        minCnt++;
      } 
      return minCnt;   
    }

}