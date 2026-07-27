class Solution {
    public int maxProduct(int[] nums) {
        int fmI = Integer.MIN_VALUE;
        int smI = Integer.MIN_VALUE;
        int n = nums.length;
        for( int i=0; i<n; i++ ){

            if( nums[i] >= fmI ){
                smI = fmI;
                fmI = nums[i];
            }
            else if( nums[i] > smI ){
                smI = nums[i] ;
            }
        }
        System.out.println(""+fmI+""+smI);
        return (fmI-1)*(smI-1);
    }
}