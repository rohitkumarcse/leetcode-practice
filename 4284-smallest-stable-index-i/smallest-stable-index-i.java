class Solution { 
    public int firstStableIndex(int[] nums, int k) { 
         int n = nums.length;
         int min[] = new int[n];
         min[n-1] = nums[n-1];

         for( int i = n-2 ; i>=0 ; i-- ){
            min[i] = Math.min(nums[i],min[i+1]);
         } 
         int max = nums[0];
         int sc = Integer.MAX_VALUE;
   
         for( int i=0; i<n;i++){
            int diff = max - min[i];
            if( diff < sc & diff <= k  ){
                sc = diff ;
                return i;
            }
            max = Math.max( max, nums[i]);
         }
         return -1;

    } 
}