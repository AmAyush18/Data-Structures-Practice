// Qsn Link: https://www.codingninjas.com/codestudio/problems/count-derangements_873861?leftPanelTab=0

import java.util.*;

public class Solution {
    static final int mod = (int) Math.pow(10,9)+7;
	public static long countDerangements(int n) {
	    
        //Recursion
//         return solveRec(n);
        
        //Recursion + Memoization
//         long[] dp = new long[n+1];
//         Arrays.fill(dp, -1);
//         return solveMem(n, dp);
        
        //Tabulation
//         return solveTab(n);
        
        //Space Optimisation
        return solve(n);
        
	}
    
    public static long solveRec(int n){
        //BASE CASE
        if(n == 1)
            return 0;       
        
        if(n == 2)
            return 1;
        
        long num1 = (n-1)%mod;
        long num2 = ((countDerangements(n-1))%mod) + (countDerangements(n-2)%mod);
        
        long ans = (num1 * num2) % mod; 
        
        return ans;
    }
    
    // Recursion + Memoization
    public static long solveMem(int n, long[] dp){
        
        //BASE CASE
        if(n == 1)
            return 0;       
        
        if(n == 2)
            return 1;
        
        if(dp[n] != -1)
            return dp[n];
        
        long num1 = (n-1)%mod;
        long num2 = ((solveMem(n-1, dp))%mod) + (solveMem(n-2, dp)%mod);
        
        long ans = (num1 * num2) % mod; 
        
        return dp[n] = ans;
        
    }
    
    //Tabulation
    public static long solveTab(int n){
        
        long[] dp = new long[n+1];
        
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i = 3; i<= n; i++){
            long first = dp[i-1] % mod;
            long second = dp[i-2] % mod;
            
            long sum = (first + second) % mod;
            
            long ans = ((i-1)*sum) % mod;
            
            dp[i] = ans;
        }
        return dp[n];
    }
    
    //Space Optimisation
    
    public static long solve(int n){
        long prev2 = 0;
        long prev1 = 1;
        
        for(int i = 3; i<=n; i++){
            long first = prev1 % mod;
            long second = prev2 % mod;
            long sum = (first + second)%mod;
            
            long ans = ((i-1) * sum) % mod;
            
            prev2 = prev1;
            prev1 = ans;
        }
        
        return prev1;
    }
}
