// Problem Link: https://practice.geeksforgeeks.org/problems/special-matrix4201/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution
{
    final int mod = 1000000007;
    public int FindWays(int n, int m, int[][] blocked)
    {
        // Code here
        int[][] mx = new int[n][m];
        
        for(int i = 0; i < blocked.length; i++){
            mx[blocked[i][0]-1][blocked[i][1]-1] = -1;
        }
        
        if(mx[0][0] == -1) return 0;
        
        // return recursive(n-1, m-1, mx);
        
//         int[][] dp = new int[n][m];
        // return recMem(n-1, m-1, mx, dp)%mod;
        
//         return tabulation(n, m, mx);
        
        return spaceOptim(n, m, mx);        
    }
    
    // Recursive 
    int recursive(int i, int j, int[][] mx){
        
        if(i == 0 && j == 0){
            return 1;
        }
        
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(mx[i][j] == -1){
            return 0;
        }
        
        int up = recursive(i-1, j, mx);
        int left = recursive(i, j-1, mx);
        
        return (up + left);
    }
    
    // Recursion + Memoization
    int recMem(int i, int j, int[][] mx, int[][] dp){
        
        if(i == 0 && j == 0){
            return 1;
        }
        
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(mx[i][j] == -1){
            return 0;
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        int up = recMem(i-1, j, mx, dp) % mod;
        int left = recMem(i, j-1, mx, dp) % mod;
        
        return dp[i][j] = (up + left) % mod;
    }
    
    // Tabulation
    int tabulation(int m, int n, int[][] mx){
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    if(mx[i][j] != -1){
                        int up = 0, left = 0;
                        if(i > 0) up = dp[i-1][j] % mod;
                        if(j > 0) left = dp[i][j-1] % mod;
                        
                        dp[i][j] = (up + left) % mod;
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        
        return dp[m-1][n-1] % mod;
    }    
    
    // Space Optimisation
    int spaceOptim(int m, int n, int[][] mx){
        
        int[] prev = new int[n];
        
        for(int i = 0; i < m; i++){
            int[] curr = new int[n];
            
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) curr[j] = 1;
                else{
                    if(mx[i][j] != -1){
                        int up = 0, left = 0;
                        if(i > 0) up = prev[j] % mod;
                        if(j > 0) left = curr[j-1] % mod;
                        
                        curr[j] = (up + left) % mod;
                    }else{
                        curr[j] = 0;
                    }
                }
            }
            prev = curr.clone();
        }
        
        return prev[n-1];
    }
}
