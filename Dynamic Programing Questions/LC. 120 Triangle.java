// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below. 
// More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        // recursion
        // return recur(0,0, triangle);
        
        // recursion + memoization
//         List<List<Integer>> dp = new ArrayList<>();
//         for(int i = 0; i < triangle.size(); i++){
//             List<Integer> temp = new ArrayList<>();
//             dp.add(temp);
//             for(int j = 0; j < triangle.get(i).size(); j++){
//                 dp.get(i).add(0);
//             }
//         }
        
//         return recMem(0, 0, triangle, dp);
        
        // tabulation
        // return tabulation(triangle);
        
        // Space Optimisation
        return spaceOptim(triangle);
        
    }
    
    int recur(int i, int j, List<List<Integer>> triangle){
        if(i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        
        int down = triangle.get(i).get(j) + recur(i+1, j, triangle);
        int diag = triangle.get(i).get(j) + recur(i+1, j+1, triangle);
        
        return Math.min(down, diag);
    }
    
    int recMem(int i, int j, List<List<Integer>> triangle, List<List<Integer>> dp){
        if(i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        // System.out.println(i +" "+ j);
        if(dp.get(i).get(j) != 0){
            return dp.get(i).get(j);
        }
        
        int down = triangle.get(i).get(j) + recMem(i+1, j, triangle, dp);
        int diagnol = triangle.get(i).get(j) + recMem(i+1, j+1, triangle, dp);
        
        int temp = Math.min(down, diagnol);
        
        dp.get(i).set(j, temp);
        
        return temp;
    }
    
     // T.C:- O(N*N) | S.C:- O(N*N)
    int tabulation(List<List<Integer>> triangle){
        
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // Initializing the base case ourselves
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        
        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        
        return dp[0][0];
    }
    
    //
    int spaceOptim(List<List<Integer>> triangle){
        
        int n = triangle.size();
        int[] next = new int[n];
        
        for(int j = 0; j < n; j++){
            next[j] = triangle.get(n-1).get(j);
        }
        
        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[n];
            
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + next[j];
                int diagonal = triangle.get(i).get(j) + next[j+1];
                
                curr[j] = Math.min(down, diagonal);
            }
            next = curr.clone();
        }
        
        return next[0];
    }
}
