 class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // return solve(values, 0, n-1);
        
        int[][] dp = new int[n][n];
        
        // return solve(values, 0, n-1, dp);
        
        return solve(values);
    }
    
    //Recursion
    int solve(int[] values, int i, int j){
        //base case
        if(i+1 == j)
            return 0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int k = i+1; k<j; k++){
            int temp = values[i]*values[j]*values[k] + solve(values, i, k) + solve(values, k, j);
            ans = Math.min(ans, temp);
        }
        
        return ans;
    }
    
    // Recursion + Memoization
    int solve(int[] values, int i, int j, int[][] dp){
        
        //base case
        if(i+1 == j)
            return 0;
        
        if(dp[i][j] != 0)
            return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        
        for(int k = i+1; k<j; k++){
            int temp = values[i]*values[j]*values[k] + solve(values, i, k, dp) + solve(values, k, j, dp);
            ans = Math.min(ans, temp);
        }
        return dp[i][j] = ans;
    }
    
    // Tabulation
    int solve(int[] val){
        
        int n = val.length;
        
        // Create DP Array
        int[][] dp = new int[n][n];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = i+2; j<n; j++){
                
                int ans = Integer.MAX_VALUE;
                for(int k = i+1; k<j; k++){
                    int temp = val[i]*val[j]*val[k] + dp[i][k] + dp[k][j];
                    ans = Math.min(ans, temp);
                }
                dp[i][j] = ans;
            }
        }
        
        return dp[0][n-1];
    }
            
}   
