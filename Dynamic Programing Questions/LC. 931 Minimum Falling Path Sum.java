class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int mini = (int)1e8;
        
        // recursion 
        // for(int j = 0; j < n; j++){
        //     mini = Math.min(mini, recur(n-1, j, matrix));
        // }
        
        //recursion + memoization
        // int[][] dp = new int[n][n];
        // for(int j = 0; j < n; j++){
        //     mini = Math.min(mini, recMem(n-1, j, matrix, dp));
        // }
        
        // tabulation        
        int[][] dp = new int[n][n];
        
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int up = (int)1e8, ld = (int)1e8, rd = (int)1e8;
                up = matrix[i][j] + dp[i-1][j];
                if(j-1 >= 0) ld = matrix[i][j] + dp[i-1][j-1];
                if(j+1 < n) rd = matrix[i][j] + dp[i-1][j+1];
                
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        
        for(int j = 0; j < n; j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        
        return mini;
        
    }
    
    int recur(int i, int j, int[][] matrix){
        
        if(j < 0 || j >= matrix[0].length){
            return (int)1e8;
        }
        if(i == 0) return matrix[0][j];
        
        int up = matrix[i][j] + recur(i-1, j, matrix);
        int ld = matrix[i][j] + recur(i-1, j-1, matrix);
        int rd = matrix[i][j] + recur(i-1, j+1, matrix);
        
        return Math.min(up, Math.min(ld, rd));
    }
    
    int recMem(int i, int j, int[][] matrix, int[][] dp){
        if(j < 0 || j >= matrix[0].length){
            return (int)1e8;
        }
        if(i == 0) return matrix[0][j];
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int up = matrix[i][j] + recMem(i-1, j, matrix, dp);
        int ld = matrix[i][j] + recMem(i-1, j-1, matrix, dp);
        int rd = matrix[i][j] + recMem(i-1, j+1, matrix, dp);
        
        return dp[i][j] = Math.min(up, Math.min(ld, rd));
    }
    
}
