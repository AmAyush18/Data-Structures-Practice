// Problem Link: https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1

class Solution
{
    public int MinSquares(int n)
    {
        // return solve(n);
        
        int[] dp = new int[n+1];
        // return solve(n, dp);
    
        return solveTab(n);
        
    }
    
    //Recursion
    
    int solve(int n){
        if(n==0)
            return 0;
        
        int ans = n;
        for(int i = 1; i*i <= n; i++){
            int temp = i * i;
            ans = Math.min(ans, 1+solve(n-temp));
        }
        
        return ans;
    }
    
    //Recursion + Memoization
    
    int solve(int n, int[] dp){
        if(n==0)
            return 0;
            
        if(dp[n] != 0)
            return dp[n];
            
        int ans = n;
        
        for(int i=1; i*i <= n; i++){
            int temp = i * i;
            ans = Math.min(ans, 1+solve(n-temp, dp));
        }
        
        dp[n] = ans;
        return dp[n];
    }
    
    // Tabulation
    
    int solveTab(int n){
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int ans = n;
        
        for(int i=1; i<=n; i++){
            
            for(int j = 1; j*j <=n; j++){
                int temp = j * j;
                if(i-temp >= 0){
                    dp[i] = Math.min(dp[i],1 + dp[i-temp]);
                }
            }
        }
        return dp[n];
        
    }
    
}
