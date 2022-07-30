class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        
        // int ans = Math.min(solve(cost, n-1), solve(cost, n-2));
        /*
        int[]  dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        int ans = Math.min(solve(cost, n-1), solve(cost, n-2, dp));
        return ans;
        */
        
        return solve(cost, n);
        
    }
    
    // using simple recursion - TLE
    /*
    public int solve(int[] cost, int n){
        
        //base case
        if(n == 0)
            return cost[0];
        
        if(n == 1)
            return cost[1];
        
        return cost[n] + Math.min(solve(cost, n-1), solve(cost, n-2));
    }
    */
    
    // Using Recursion + Memoization
    /*
    public int solve(int[] cost, int n, int[] dp){
        if(n == 0)
            return cost[0];
        
        if(n == 1)
            return cost[1];
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = cost[n] + Math.min(solve(cost,n-1, dp), solve(cost, n-2, dp));
    }
    */
    
    //Tabulation
    /*
    public int solve(int[] cost, int n){
        
        //step-1 Creation of DP Table
        int[] dp = new int[n+1];
        
        //step-2 Base Case Analysis
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        //step-3 for other stairs from 2nd  to n-1th stair
        for(int i = 2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        
        return Math.min(dp[n-1], dp[n-2]);      
        
    }
    */
    
    //Space Optimization
    
    public int solve(int[] cost, int n){
        
        int prev2 = cost[0];
        int prev1 = cost[1];
        
        if(n == 0)
            return prev2;
        
        if(n == 1)
            return prev1;
        for(int i = 2; i<n; i++){
            int cur = cost[i] + Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        
        return Math.min(prev1, prev2);
        
    }
}
