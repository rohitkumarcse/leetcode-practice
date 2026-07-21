class Solution {
    static int cnt;
    static int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        cnt =0;
        KthSmall(root,k);
        return ans ;
    }
    public static void KthSmall( TreeNode root, int k ){
        if( root == null ) return ;
        KthSmall( root.left,k);
        cnt+=1;
        if( cnt == k ){ ans = root.val ; return ;}
        KthSmall(root.right,k);
    }
}