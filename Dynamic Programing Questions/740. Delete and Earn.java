class Solution {
    
    Map<Integer, Integer> dp;    
    
    public int deleteAndEarn(int[] nums) {
        
        dp = new HashMap<>();
        
        int max = 0;
        
        for(int i : nums){
            max = Math.max(max, i);
        }
        
        int[] arr = new int[max+1];
        
        for(int i : nums){
            arr[i]++;
        }
        
        return solve(0, arr);
        
    }
    
    // Recursion + Memoization
    public int solve(int i, int[] arr){
        
        // BASE CASE
        if(i >= arr.length)
            return 0;
        
        if(dp.containsKey(i))
            return dp.get(i);
        
        int ans = Math.max(arr[i]*i + solve(i+2, arr), solve(i+1, arr));
        
        dp.put(i, ans);
        
        return ans;
    }
}
