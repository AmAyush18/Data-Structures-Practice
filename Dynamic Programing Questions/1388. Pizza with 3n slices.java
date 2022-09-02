class Solution {
    public int maxSizeSlices(int[] slices) {
     
        //Similar to house robbery Question
        
        int k = slices.length;
        
//         int case1 = solve(0, k-2, slices, k/3);  // when eating first slice
//         int case2 = solve(1, k-1, slices, k/3);  // when eating second slice
        
//         return Math.max(case1, case2);        
        
//         int[][] dp1 = new int[k][k];
//         int[][] dp2 = new int[k][k];
        
//         int case1 = solve(0, k-2, slices, k/3, dp1);
//         int case2 = solve(1, k-1, slices, k/3, dp2);
        
//         return Math.max(case1, case2);
        
        // return solve(slices);
        
        return solveSO(slices);
                
    }
    
    //Tabulation    
    int solve(int ind, int endInd, int[] slices, int n){
        
        if(n == 0 || ind > endInd){
            return 0;
        }
        
        int eat = slices[ind] + solve(ind+2, endInd, slices, n-1);
        
        int notEat = 0 + solve(ind+1, endInd, slices, n);
        
        return Math.max(eat, notEat);
        
    }
    
    //Recursion + Memoization
    int solve(int ind, int endInd, int[] slices, int n, int[][] dp){
        
        if(n == 0 || ind > endInd){
            return 0;
        }
        
        if(dp[ind][n] != 0)
            return dp[ind][n];
        
        int eat = slices[ind] + solve(ind+2, endInd, slices, n-1, dp);
        
        int notEat = 0 + solve(ind+1, endInd, slices, n, dp);
        
        return dp[ind][n] = Math.max(eat, notEat);
        
    }
    
    //Tabulation
    int solve(int[] slices){
        
        int k = slices.length;
        
        int[][] dp1 = new int[k+2][k];
        int[][] dp2 = new int[k+2][k];
        
        for(int ind = k-2; ind >=0; ind--){
            
            for(int n = 1; n <= k/3; n++){
                
                int eat = slices[ind] + dp1[ind+2][n-1];
                int notEat = 0 + dp1[ind+1][n];
                
                dp1[ind][n] = Math.max(eat,notEat);                
            }
        }
        
        for(int ind = k-1; ind >0; ind--){
            
            for(int n = 1; n <= k/3; n++){
                
                int eat = slices[ind] + dp2[ind+2][n-1];
                int notEat = 0 + dp2[ind+1][n];
                
                dp2[ind][n] = Math.max(eat,notEat);                
            }
        }
        
        return Math.max(dp1[0][k/3], dp2[1][k/3]);
    }
    
    //Space Optimisation
    int solveSO(int[] slices){
        
        int k = slices.length;
               
        // For Case - 1
        int[] cur = new int[k];  // replace with dp[ind]
        int[] prev = new int[k]; // replace with dp[index+1]
        int[] next = new int[k]; // replace with dp[index+2];
        for(int ind = k-2; ind >=0; ind--){
            
            for(int n = 1; n <= k/3; n++){
                
                int eat = slices[ind] + next[n-1];
                int notEat = 0 + cur[n];
                
               prev[n] = Math.max(eat,notEat);                
            }
            next = cur.clone();
            cur = prev.clone();
        }
        int case1 = cur[k/3];
        
        //For Case - 2
        int[] cur1 = new int[k];  // replace with dp[ind+1]
        int[] prev1 = new int[k]; // replace with dp[ind]
        int[] next1 = new int[k]; // replace with dp[ind+2];
        for(int ind = k-1; ind >0; ind--){
            
            for(int n = 1; n <= k/3; n++){
                
                int eat = slices[ind] + next1[n-1];
                int notEat = 0 + cur1[n];
                
                prev1[n] = Math.max(eat,notEat);                
            }
            next1 = cur1.clone();
            cur1 = prev1.clone();
        }
        int case2 = cur1[k/3];
        
        return Math.max(case1, case2);
    }   
}
