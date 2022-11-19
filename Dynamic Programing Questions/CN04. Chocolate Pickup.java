//  Problem Link:- https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?leftPanelTab=0

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int maximumChocolates(int r, int c, int[][] grid) {       
        // recursion
//         return recur(0,0,c-1,c, grid);
        
        // recursion + memoization
        int[][][] dp = new int[r][c][c];
//         return recMem(0, 0, c-1, c, grid, dp);
        
        // tabulation
        
        // handle the base case
        for(int j1 = 0; j1 < c; j1++){
            for(int j2 = 0; j2 < c; j2++){
                if(j1 == j2) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }
        
        // nested loops
        for(int i = r-2; i  >= 0; i--){
            for(int j1 = 0; j1 < c; j1++){
                for(int j2 = 0; j2 < c; j2++){
                    int maxi = (int)-1e8;
                    // explore all paths of alice and bob simultaneously
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int value = 0;
                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            
                            if(j1+dj1 >= 0 && j1+dj1 < c && j2+dj2 >= 0 && j2+dj2 < c){
                                value += dp[i+1][j1+dj1][j2+dj2];
                            }
                            else{
                                value += (int)-1e8;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][c-1];        
	}
    
    static int recur(int i, int j1, int j2, int c, int[][] grid){
        // out of bound
        if(j1 < 0 || j1 >= c || j2 < 0 || j2 >= c){
            return (int)-1e8;
        }
        
        if(i == grid.length-1){
            if(j1 == j2) return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        
        int maxi = (int)-1e8;
              
        // explore all paths of alice and bob simultaneously
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int value = 0;
                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                
                value += recur(i+1, j1 + dj1, j2 + dj2, c, grid);
                maxi = Math.max(maxi, value);
            }
        }
        
        return maxi;
    }
    
    // Recursion + Memoization
    static int recMem(int i, int j1, int j2, int c, int[][] grid, int[][][] dp){
       if(j1 < 0 || j1 >= c || j2 < 0 || j2 >= c){
            return (int)-1e8;
        }
        
        if(i == grid.length-1){
            if(j1 == j2) return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        
        if(dp[i][j1][j2] != 0){
            return dp[i][j1][j2];
        }
        
        int maxi = (int)-1e8;
        
        // explore all paths of alice and bob simultaneously
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int value = 0;
                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                
                value += recMem(i+1, j1 + dj1, j2 + dj2, c, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }
        
        return dp[i][j1][j2] = maxi;
    }
}
