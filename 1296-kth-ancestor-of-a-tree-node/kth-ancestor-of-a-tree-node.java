class TreeAncestor {
    int parents[][];
    int rows;
    int cols;
    public TreeAncestor(int n, int[] parent) {
        cols = (int)(Math.log(n) / Math.log(2))+1;
        rows = n;
        parents = new int[rows][cols];
        for( int []parT : parents) Arrays.fill(parT,-1);
         
         // fill the first row of the parents 
        for( int node = 0 ; node < n ; node++ )
            parents[node][0] = parent[node];

        // fill the remaining nodes parents with recurrence relation
        for( int j = 1; j<cols; j++){
            for( int node =0; node <n ; node++ ){
                if( parents[node][j-1]!=-1){
                    parents[node][j] = parents[parents[node][j-1]][j-1];
                }
            }
        }
        
    }
    
    public int getKthAncestor(int node, int k) {
        for( int j=0;j<cols; j++ ){
            if(( k&( 1<<j )) > 0 ){
                node = parents[node][j];
                if( node == -1 ) return -1;
            }

        }
        return node;
    }
}

