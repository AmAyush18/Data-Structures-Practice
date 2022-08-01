// Qsn Link:  https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1

class Solution
{
    final long mod = 1000000007;
    long countWays(int n,int k)
    {
        //recursion
        // return solve(n,k);
        
        //Recursion + Memoization
        // long[] dp = new long[n+1];
        // Arrays.fill(dp, -1);
        
        // return solve(n, k, dp);
        
        //Tabulation
        // return solve(n, k);
        
        //Space Optimisation
        return solve2(n, k);
        
    }
    
    //Recursion
    // int solve(int n, int k){
    //     //base case
    //     if(n == 1)
    //         return k;
            
    //     if(n == 2)
    //         return add(k, multiply(k, k-1));
            
    //     int ans = add(multiply(solve(n-2, k), k-1), multiply(solve(n-1, k), k-1));
        
    //     return ans;
    // }
    
    //Recursion + Memoization 
    long solve(int n, int k, long[] dp){
        
        if(n == 1)
            return k;
            
        if(n == 2)
            return add(k, multiply(k, k-1));
            
        if(dp[n] != -1)
            return dp[n];
            
        long ans = add(multiply(solve(n-2, k, dp), k-1), multiply(solve(n-1, k, dp), k-1));
        
        return dp[n] = ans;
            
    }
    
    //Tabulation
    
    long solve(int n, int k){
        
        if(n==1)
            return k;
        
        long[] dp = new long[n+1];
        
        dp[1] = k;
        dp[2] = add(k, multiply(k, k-1));
        
        for(int i = 3; i<= n; i++){
            
            long ans = add(multiply(dp[i-2], k-1), multiply(dp[i-1], k-1));
            
            dp[i] = ans;
            
        }
        
        return dp[n];
    }
    
    // Space Optimisation
    long solve2(int n, int k){
        
        if(n == 1)
            return k;
        
        long prev2 = k;
        long prev1 = add(k, multiply(k, k-1));
        
        for(int i = 3; i<=n; i++){
            
            long cur = add(multiply(prev2, k-1), multiply(prev1, k-1));
            
            prev2 = prev1;
            prev1 = cur;
            
        }
        
        return prev1;
        
    }
    
    long add(long a, long b){
        
        return (a%mod + b%mod)%mod;
    }
    
    long multiply(long a, long b){
        
        return ((a%mod) * (b%mod))%mod;
    }
    
}
