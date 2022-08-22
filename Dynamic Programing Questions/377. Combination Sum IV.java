class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        // int ans = recursion(nums, target);
        // return ans;
        
        // int[] dp = new int[target+1];
        // Arrays.fill(dp,-1);
        // int ans = recurMem(nums, target, dp);
        // return ans;
        
        return tab(nums, target);
        
    }
    
    int recursion(int[] nums, int target){
        
        //base case
        if(target == 0)
            return 1;
        
        if(target<0)
            return 0;
        
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            ans += recursion(nums, target-nums[i]);
        }
        
        return ans;
        
    }
    
    int recurMem(int[] nums, int target, int[] dp){
        
        if(target < 0)
            return 0;
        
        if(target == 0)
            return 1;
        
        if(dp[target] != -1)
            return dp[target];
        
        int ans = 0;
        for(int i =0; i<nums.length; i++)
            ans += recurMem(nums, target-nums[i], dp);
        
        dp[target] = ans;
        
        return dp[target];
        
    }
    
    int tab(int[] nums, int target){
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        // traversing over 1 to target in dp array
        for(int i = 1; i<=target; i++){
            
            //traversing over nums array
            for(int j = 0; j<nums.length; j++){
                if(i-nums[j] >= 0){
                    dp[i] += dp[i-nums[j]];
                }
            }           
        }
        
        return dp[target];
        
    }
}
