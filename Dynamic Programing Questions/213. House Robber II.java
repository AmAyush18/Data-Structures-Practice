class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
               
        int ans1 = solveTab(nums, 0, nums.length-2); 
        int ans2 = solveTab(nums, 1, nums.length-1);
        
        return Math.max(ans1, ans2);
        
    }
    //Solve Using Tabulation
    int solveTab(int[] nums, int s, int n){
        
        int[] dp = new int[nums.length];
        dp[s] = nums[s];
        
        for(int i = s+1; i<=n; i++){
            int incl = 0;
            if(i == s+1){
                incl = nums[i];
            }else{
                incl = nums[i] + dp[i-2];
            }
            int excl = dp[i-1];
            
            dp[i] = Math.max(incl, excl);
        }
        
        return dp[n];
        
    }
    
}
