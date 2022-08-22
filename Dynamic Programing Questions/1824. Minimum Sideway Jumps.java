class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        // return solve(obstacles, 2, 0);
        
        int[][] dp = new int[4][n];
        // return solve(obstacles, 2, 0, dp);
        
        // return solveTab(obstacles);
        
        return solve(obstacles);
        
    }
    
    // Recursion    
    int solve(int[] obstacles, int curlane, int pos){
        
        int n = obstacles.length-1;
        //base case
        if(pos == n)
            return 0;
        
        if(obstacles[pos+1] != curlane){
            return solve(obstacles, curlane, pos+1);
        }
        else{            
            //sideways jump
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i<=3; i++){
                if(curlane != i && obstacles[pos] != i)
                    ans = Math.min(ans, 1 + solve(obstacles, i, pos));
            }            
         
            return ans;
        }        
    }
    
    //Recursion + Memoization
    int solve(int[] obstacles, int curlane, int pos, int[][] dp){
        
        int n = obstacles.length-1;
        
        //base case
        if(pos == n)
            return 0;
        
        if(dp[curlane][pos] != 0)
            return dp[curlane][pos];
        
        if(obstacles[pos+1] != curlane){
            return solve(obstacles, curlane, pos+1, dp);
        }
        else{
            //sideways jump
            int ans = Integer.MAX_VALUE; 
            for(int i = 1; i<=3; i++){
                if(curlane != i && obstacles[pos] != i)
                    ans = Math.min(ans, 1 + solve(obstacles, i, pos, dp));
            }
            dp[curlane][pos] = ans;
            
            return dp[curlane][pos];
        }
        
    }
    
    //Tabulation
    int solveTab(int[] obstacles){
        
        int n = obstacles.length-1;
        
        //Create DP Array
        int[][] dp = new int[4][n+1];
        for(int i=0; i<=3; i++){
            Arrays.fill(dp[0], Integer.MAX_VALUE);
        }
        
        //Analyse the Base Case
        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;
        
        for(int pos = n-1; pos >=0; pos--){
            
            for(int curlane = 1; curlane <= 3; curlane++){
                
                if(obstacles[pos+1] != curlane){// when lane is clear of obstacles
                    dp[curlane][pos] = dp[curlane][pos+1];
                }
                else{
                    //sideways jump
                    int ans = Integer.MAX_VALUE;
                    for(int i = 1; i<=3; i++){
                        if(curlane != i && obstacles[pos] != i){
                            ans = Math.min(ans, 1 + dp[i][pos+1]);
                        }   
                    }
                    dp[curlane][pos] = ans;
                }
            }
            
        }
        return Math.min(dp[2][0], Math.min(1 + dp[1][0], 1 + dp[3][0]));
    }
    
    //Space Optimisation
    
    int solve(int[] obstacles){
        
        int n = obstacles.length-1;
        
        int[] cur = new int[4];
        int[] next = new int[4];
        Arrays.fill(cur, Integer.MAX_VALUE);
        Arrays.fill(next, Integer.MAX_VALUE);
        
        next[0] = 0;
        next[1] = 0;
        next[2] = 0;
        next[3] = 0;
        
        for(int curpos = n-1; curpos >= 0; curpos--){
            
            for(int curlane = 1; curlane <= 3; curlane++){
                
                if(obstacles[curpos+1] != curlane){
                    cur[curlane] = next[curlane];
                }
                else{
                    int ans = Integer.MAX_VALUE;
                    
                    for(int i = 1; i <= 3; i++){
                        if(curlane != i && obstacles[curpos] != i)
                            ans = Math.min(ans, 1 + next[i]);
                    }
                    cur[curlane] = ans;
                }
                               
            }
            // after each iteration next is made cur
            next = cur;
        }
        return Math.min(next[2], Math.min(1 + next[1], 1 + next[3]));
    }
    
}
