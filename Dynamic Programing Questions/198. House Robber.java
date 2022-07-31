class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        // return solveRec(nums, n-1);
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        // return recMem(nums, n-1, dp);
        
        return solveTab(nums, n);
        
    }
    
    //Recursion
    
    int solveRec(int[] nums, int n){
        
        if(n == 0)
            return nums[0];
        
        if(n < 0)
            return 0;
        
        int incl = solveRec(nums, n-2) + nums[n];
        int excl = solveRec(nums, n-1) + 0;
        
        return Math.max(incl, excl);
    }
    
    //Recursion + Memoization
    
    int recMem(int[] nums, int n, int[] dp){
        
        if(n == 0)
            return nums[0];
        
        if(n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        int incl = recMem(nums, n-2, dp) + nums[n];
        int excl = recMem(nums, n-1, dp);
        
        return dp[n] = Math.max(incl, excl);
        
    }
    
    // Tabulation
    
    int solveTab(int[] nums, int n){
        
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        
        for(int i = 1; i<n; i++){
            
            int incl = 0;
            
            if(i == 1){
                incl = nums[i];
            }else{
                incl = dp[i-2] + nums[i];
            }
            int excl = dp[i-1];
            
            dp[i] = Math.max(incl, excl);
            
        }
        
        return dp[n-1];
        
    }
    
    //Space Optimized Approach
    
    int solveSpace(int[] nums){
        
        int n = nums.length;
        
        int prev1 = nums[0];
        int prev2 = 0;
        
        for(int i = 1; i<n; i++){
            
            int incl = prev2 + nums[i];
            int excl = prev1 + 0;
            
            int cur = Math.max(incl, excl);
            
            prev2 = prev1;
            prev1 = cur;
            
        }
        
        return prev1;
    }
    
}
