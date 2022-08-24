// Problem Link: https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1

class Solution{
    static int max;
    static int maxSquare(int n, int m, int mat[][]){

        // Recursion
        // max = 0;
        // // solve(mat, 0, 0);
        // // return max;
        
        // Recursion + Memoization
        // max = 0;
        // int[][] dp = new int[n][m];
        // for(int i = 0; i<n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // solve(mat, 0, 0, dp);
        // return max;
        
        // Tabulation
        // max = 0;
        // solve(mat);
        // return max;
        
        //Space Optimisation
        max = 0;
        solveSO(mat);
        return max;
    } 
    
    //Recursion
    static int solve(int[][] mat, int i, int j){
        
        if(i >= mat.length || j >= mat[0].length)
            return 0;
            
        int right = solve(mat, i, j+1);
        int diagonal = solve(mat, i+1, j+1);
        int down = solve(mat, i+1, j);
        
        if(mat[i][j] == 1){
            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            max = Math.max(max, ans);
            return ans;
        }
        else{
            return 0;
        }
    }
    
    //Recursion + Memoization
    static int solve(int[][] mat, int i, int j, int[][] dp){
        
        if(i >= mat.length || j >= mat[0].length){
            return 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int right = solve(mat, i, j+1, dp);
        int diagonal = solve(mat, i+1, j+1, dp);
        int down = solve(mat, i+1, j, dp);
        
        if(mat[i][j] == 1){
            
            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            max = Math.max(max, ans);
            dp[i][j] = ans;
            return ans;
        }
        else{
            return dp[i][j] = 0;
        }
    }
    
    // Tabulation [Bottom-up Approach]
    static int solve(int[][] mat){
        
        int row = mat.length;
        int col = mat[0].length;
        //Create a DP Array
        int[][] dp = new int[row+1][col+1];
        
        for(int i = row-1; i >= 0; i--){
            
            for(int j = col-1; j >= 0; j--){

                int right = dp[i][j+1];
                int diagonal = dp[i+1][j+1];
                int down = dp[i+1][j];
                
                if(mat[i][j] == 1){
                    dp[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j]= 0;
                }
            }
            
        }
        return dp[0][0];
    }
    
    //Space Optimisation
    static int solveSO(int[][] mat){
        
        int row = mat.length;
        int col = mat[0].length;
        
        int[] curr = new int[col+1];
        int[] next = new int[col+1];
        
        for(int i=row-1; i>=0; i--) {
          for(int j=col-1; j>=0; j--) {
            //move to the right side
            int right = curr[j+1];
            //move to the digonsl side
            int diagonal = next[j+1];
            //move to the downword side
            int down = next[j];
            
            //now check current position
            if(mat[i][j] == 1) {
                curr[j] = 1 + Math.min(right, Math.min(diagonal,down));
                max = Math.max(max,curr[j]);
            } else {
                curr[j] = 0;
            }
        }
        next = curr;
    }
    return next[0];
    }
    
}
