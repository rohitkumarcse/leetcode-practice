class Solution {
    public int[] findArray(int[] pref) {
        int  n = pref.length;
        int pre[] = new int[n];
        pre[0] = pref[0];

        for( int i=1; i < n; i++ ){
           pre[i] = pref[i]^pref[i-1];
        }
        return pre;
    }
}