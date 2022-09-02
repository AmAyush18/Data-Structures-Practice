// Problem Link: https://practice.geeksforgeeks.org/problems/dice-throw5349/1
// LeetCode: 1155

class Solution {
    static long noOfWays(int m, int n, int x) {
        
        // return solve(n, m, x);
        
        // long[][] dp = new long[n+1][x+1];
        
        // for(long []arr : dp)
        //     Arrays.fill(arr, -1);
        
        // return solveMem(n, m, x, dp);
        
        // return solveTab(n, m, x);
        
        return solveSO(n, m, x);
    }
    
    static long solve(int dice, int faces, int target){
        
        //base case
        if(target < 0)
            return 0;
            
        if(dice == 0 && target != 0)
            return 0;
            
        if(target == 0 && dice != 0)
            return 0;
            
        if(dice == 0 && target == 0)
            return 1;
            
        long ans = 0;
        for(int i = 1; i <= faces; i++){
            ans += solve(dice-1, faces, target-i);
        }
        
        return ans;
    }
    
    static long solveMem(int dice, int faces, int target, long[][] dp){
        
        //base case
        if(target < 0)
            return 0;
            
        if(dice == 0 && target != 0)
            return 0;
            
        if(target == 0 && dice != 0)
            return 0;
            
        if(dice == 0 && target == 0)
            return 1;
            
        if(dp[dice][target] != -1)
            return dp[dice][target];
            
        long ans = 0;
        for(int i = 1; i <= faces; i++){
            ans += solveMem(dice-1, faces, target-i, dp);
        }
        
        return dp[dice][target] = ans;
    }
    
    static long solveTab(int dices, int faces, int target){
        
        long[][] dp = new long[dices+1][target+1];
        
        dp[0][0] = 1;  // dice == 0 and target == 0 return 1 waala base case
        long ans;
        for(int dice = 1; dice<=dices; dice++){
           
           for(int x = 1; x <= target; x++){
            
                ans = 0;
                for(int face = 1; face <= faces; face++){
                    if(x-face >= 0)
                        ans += dp[dice-1][x-face];
                }
                
                dp[dice][x] = ans;
           }
        }
        
        return dp[dices][target];
    }
    
    //Space Optimised Approach
    static long solveSO(int dices, int faces, int target){
        
        long[] prev = new long[target+1];  // dp[dice-1]
        long[] cur = new long[target+1];   // dp[dice]
        
        //after analysing base case
        prev[0] = 1;
        
        long ans;
        for(int dice = 1; dice<=dices; dice++){
           
           for(int x = 1; x <= target; x++){
            
                ans = 0;
                for(int face = 1; face <= faces; face++){
                    if(x-face >= 0)
                        ans += prev[x-face];
                }
                cur[x] = ans;
           }
           prev = cur.clone();
        }
        
        return prev[target];
    }
    
    //LeetCode Accepted
    int solveSO(int dices, int faces, int target){
        
        int[] prev = new int[target+1];  // dp[dice-1]
        int[] cur = new int[target+1];   // dp[dice]
        
        //after analysing base case
        prev[0] = 1;
        
        int ans;
        for(int dice = 1; dice<=dices; dice++){
           
           for(int x = 1; x <= target; x++){
            
                ans = 0;
                for(int face = 1; face <= faces; face++){
                    if(x-face >= 0)
                        ans = ans%mod + prev[x-face] % mod;
                }
                cur[x] = ans % mod;
           }
           prev = cur.clone();
        }
        
        return prev[target];
    }
    
}
