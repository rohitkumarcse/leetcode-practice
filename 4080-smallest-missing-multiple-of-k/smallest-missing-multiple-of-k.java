class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for( int i=0; i<n; i++ ) set.add(nums[i]);
        for( int i=0; i<n; i++ ){
            if(!set.contains(k*(i+1))){
                   return k*(i+1);
            }
        }
        return k*(n+1);
    }
}