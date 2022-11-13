 // Problem Link: https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470?leftPanelTab=0

import java.util.* ;
import java.io.*; 
public class Solution {

public static int uniquePaths(int m, int n) {
		
        // Recursive solution
//         return recursive(m-1, n-1);
        
        //Recursive + Memoization
//         int[][] dp = new int[m][n];
//         return recMem(m-1, n-1, dp);
        
        //Tabulation
//         return tabulation(m, n);
        
        //Space Optimisation
        return spaceOptim(m, n);
	}
    
    //Recursive solution
    static int recursive(int m, int n){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        
        int up = recursive(m, n-1);
        int left = recursive(m-1, n);
        
        return ( up + left );
    }
    
    // Recursive + Memoization
    static int recMem(int m, int n, int[][] dp){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        
        if(dp[m][n] != 0){
            return dp[m][n];
        }
        
        int up = recMem(m, n-1, dp);
        int left = recMem(m-1, n, dp);
        
        return dp[m][n] = ( up + left );
    }
    
    // Tabulation
    static int tabulation(int m, int n){
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up = 0, left = 0;
                    if(i > 0) left = dp[i-1][j];
                    if(j > 0) up = dp[i][j-1];
                    
                    dp[i][j] = up + left;
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    // Space Optimisation
    static int spaceOptim(int m, int n){
        int[] prev = new int[n];
        
        for(int i = 0; i < m; i++){
            int[] curr = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                } 
                else{
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j-1];
                    
                    curr[j] = up + left;
                }
            }
            prev = curr.clone();
        }
        
        return prev[n-1];
    }
}
