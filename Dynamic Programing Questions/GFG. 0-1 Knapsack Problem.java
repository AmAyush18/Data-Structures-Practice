// Qsn Link: https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         //Recursion
        //  return solve(wt, val, W, n-1);
         
         
         //Recursion + Memoization
        //  int[][] dp = new int[n][W+1];
        //  return solve(wt, val, W, n-1, dp);
        
        //Tabulation
        return solve(wt, val, W, n);
         
    } 
    
    //Recursion
    // static int solve(int[] wt, int[] val, int W, int ind){
        
    //     //Base case
    //     if(ind == 0){
    //         if(wt[0] <= W){
    //           return val[0]; 
    //         }
    //         return 0;
    //     }
        
    //     int include = 0;
    //     if(wt[ind] <= W)
    //         include = val[ind] + solve(wt, val, W-wt[ind], ind-1);
        
    //     int exclude = 0 + solve(wt, val, W, ind-1);
        
    //     int ans = Math.max(include, exclude);
         
    //     return ans;
    // }
    
    //Recursion + Memoization
    
    static int solve(int[] wt, int[] val, int W, int ind, int[][] dp){
        
        //Base Case
        if(ind == 0){
            if(wt[0] <= W)
                return val[0];
            else
                return 0;
        }
        
        if(dp[ind][W] != 0)
            return dp[ind][W];
        
        int include = 0;
        if(wt[ind] <= W)
            include = val[ind] + solve(wt, val, W-wt[ind], ind-1, dp);
        
        int exclude = 0 + solve(wt, val, W, ind-1, dp);
        
        return dp[ind][W] = Math.max(include, exclude);
        
    }
    
    //Tabulation
    
    static int solve(int[] wt, int[] val, int W, int n){
        
        //step1:
        int[][] dp = new int[n][W+1];
        
        //step2: analyse base case
        for(int w = wt[0]; w<=W; w++){
            dp[0][w] = val[0];
        }
        
        //step3 : take care of remaining recursive calls
        
        for(int ind = 1; ind<n; ind++){
            
            for(int w = 0; w<=W; w++){
                
                    int incl = 0;
                    
                    if(wt[ind] <= w)
                        incl = val[ind] + dp[ind-1][w-wt[ind]];
                    
                    int excl = 0 + dp[ind-1][w];
                    
                    dp[ind][w] = Math.max(incl, excl);
            }
        }
        return dp[n-1][W];
    }
    
    // Space Optimisation
    
    static int solve2(int[] wt, int[] val, int W, int n){
        
        // step-1: 
        int[] prev = new int[W+1];
        int[] cur = new int[W+1];
        
        for(int w = wt[0]; w<= W; w++){
            prev[w] = val[0];
        }
        
        for(int ind = 1; ind < n; ind++){
            
            for(int w = 0; w<=W; w++){
                
                int incl = 0;
                
                if(wt[ind] <= w){
                    incl = val[ind] + prev[w-wt[ind]];
                }
                int excl = 0 + prev[w];
                 
                cur[w] = Math.max(incl, excl);
                
            }
        }
        
        return cur[W];
        
    }
    
}
