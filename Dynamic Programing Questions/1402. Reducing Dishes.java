class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        
        // return solve(satisfaction, 0, 1);
        int n = satisfaction.length;
        
        int[][] dp = new int[n][n+1];
        
        // return solve(satisfaction, 0, 1, dp);        
        
        // return solve(satisfaction);
        
        return solveSO(satisfaction);
        
    }
    
    //Recursion
    int solve(int[] sat, int index, int time){
        
        //base case
        if(index == sat.length)
            return 0;
                
        //including current dish
        int incl = sat[index] * time + solve(sat, index+1, time+1);
        
        //excluding current dish
        int excl = 0 + solve(sat, index+1, time);
        
        return Math.max(incl, excl);
    }
    
    // Recursion + Memoization
    int solve(int[] sat, int index, int time, int[][] dp){
        
        //base case
        if(index == sat.length)
            return 0;
                
        if(dp[index][time] != 0)
            return dp[index][time];
        
        //including current dish
        int incl = sat[index] * time + solve(sat, index+1, time+1, dp);
        
        //excluding current dish
        int excl = 0 + solve(sat, index+1, time, dp);
        
        return dp[index][time] = Math.max(incl, excl);
    }

    // Tabulation
    int solve(int[] sat){
        
        int n = sat.length;
        int[][] dp = new int[n+1][n+1+1];
        
        for(int i = n-1; i >=0; i--){
            
            for(int t = n; t >= 1; t--){
                
                int incl = sat[i]*t + dp[i+1][t+1];
                int excl = 0 + dp[i+1][t];
                
                dp[i][t] = Math.max(incl, excl);
            }
        }
        return dp[0][1];
    }
    
    //Space Optimisation
    int solveSO(int[] arr){
        int[] nxt = new int[arr.length + 1];
        
        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int[] curr = new int[arr.length + 1];
            
             for(int t = i ; t >= 0 ; t --){
                 
                 int in = arr[i]*(t+1) + nxt[t + 1];
                 int ex = nxt[t];
                 
                 curr[t] = Math.max(in, ex);
                 
             }
            
            nxt = curr;
         }
        return nxt[0];
    }
    
}
