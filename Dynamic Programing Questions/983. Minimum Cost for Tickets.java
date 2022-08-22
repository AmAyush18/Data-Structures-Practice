class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        // return solve(days.length, days, costs, 0);
        
        int[] dp = new int[days.length+1];
        // return solve(days.length, days, costs, 0, dp);
        
        return solveTab(days.length, days, costs);
        
    }
    
    // Recursion
    int solve(int n, int[] days, int[] cost, int index){
        
        //BASE CASE
        if(index >= n)
            return 0;
        
        // 1-Day pass
        int option1 = cost[0] + solve(n, days, cost, index+1);
    
        // 7-Day pass
        int i;
        for(i = index; i<n && days[i] < days[index] + 7; i++);
        
        int option2 = cost[1] + solve(n, days, cost, i);
        
        // 30-day pass
        i=index;
        for(; i<n && days[i] < days[index] + 30; i++);
        
        int option3 = cost[2] + solve(n, days, cost, i);
        
        return Math.min(option1, Math.min(option2, option3));                        
    }
    
    // Recursion + Memoization
    
    int solve(int n, int[] days, int[] cost, int index, int[] dp){
        
        //BASE CASE
        if(index >= n)
            return 0;
        
        if(dp[index] != 0)
            return dp[index];
        
        // 1-Day pass
        int option1 = cost[0] + solve(n, days, cost, index+1, dp);
    
        // 7-Day pass
        int i;
        for(i = index; i<n && days[i] < days[index] + 7; i++);
        
        int option2 = cost[1] + solve(n, days, cost, i, dp);
        
        // 30-day pass
        i=index;
        for(; i<n && days[i] < days[index] + 30; i++);
        
        int option3 = cost[2] + solve(n, days, cost, i, dp);
        
        return dp[index] = Math.min(option1, Math.min(option2, option3));         
        
    }
    
    // Tabulation    
    int solveTab(int n, int[] days, int[] cost){
        
        // Dp Array Creation
        int[] dp = new int[n+1];
        
        //Analyse Base Case
        dp[n] = 0;
        
        for(int k = n-1; k >= 0; k--){
            
            // 1-day pass
            int option1 = cost[0] + dp[k+1];
            
            // 7-day pass
            int i;
            for(i=k; i<n && days[i] < days[k]+7; i++);
            int option2 = cost[1] + dp[i];
            
            //30-day pass
            for(i=k; i<n && days[i] < days[k]+30; i++);
            int option3 = cost[2] + dp[i];
            
            dp[k] = Math.min(option1, Math.min(option2, option3));
        }
        
        return dp[0];       
    }    
}
