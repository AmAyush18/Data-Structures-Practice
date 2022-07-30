class Solution {
    public int coinChange(int[] coins, int amt) {
       
        /* Recursion
        int ans = solveRec(coins, amt);
        
        if(ans == Integer.MAX_VALUE)
            return -1;
            */
        
        /*
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, -1);
    
        int ans = solveRecMem(coins, amt, dp);
        
        if(ans == Integer.MAX_VALUE)
            return -1;
        
        return ans;
        */
        
        return solveTab(coins, amt);
    }
    
    // Recursion - TLE
    /*
    int solveRec(int[] coins, int target){
        
        //base case
        if(target == 0)
            return 0;
        
        if(target < 0)
            return Integer.MAX_VALUE;
        
        int mini = Integer.MAX_VALUE;
        
        for(int i = 0; i < coins.length; i++){
            int ans = solveRec(coins, target-coins[i]);
            if(ans != Integer.MAX_VALUE)
                mini = Math.min(mini, 1 + ans);
        }
        
        return mini;
        
    }
    */
    
    // Recursion + Memoization -> TLE
    /*
    int solveRecMem(int[] coins, int target, int[] dp){
        
        if(target == 0)
            return 0;
        
        if(target < 0)
            return Integer.MAX_VALUE;
        
        if(dp[target] != -1)
            return dp[target];
        
        int mini = Integer.MAX_VALUE;
        
        for(int i = 0; i < coins.length; i++){
            int ans = solveRecMem(coins, target-coins[i], dp);
            if(ans != Integer.MAX_VALUE)
                mini = Math.min(mini, 1+ans);
        }
        return mini;
    }
    */
    
    // Tabulation
    int solveTab(int[] coins, int target){
        
        int[] dp = new int[target+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int i = 1; i <= target; i++){
            // we're trying to solve for every amount figure from 1 to target
            // this means if we are given target = 5
            // we solve for 1... 2... 3... 4... 5...
            
            for(int j = 0; j < coins.length; j++){
                
                // we first check that if i - num[j] is a valid index or not i.e it is >=0 or not
                // then we check is dp[i - num[j]] != Integer.MAX_VALUE bcoz if it is then there will be Integer overflow after addition of 1
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
                
            }
        }
            
            if(dp[target] == Integer.MAX_VALUE)
                return -1;
            
            return dp[target];
            
        }
}
