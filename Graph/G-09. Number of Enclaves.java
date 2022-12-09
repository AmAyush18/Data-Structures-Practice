// GFG Problem Link: https://practice.geeksforgeeks.org/problems/number-of-enclaves/1
// LeetCode Problem Link: https://leetcode.com/problems/number-of-enclaves/

class Solution {

    int n, m;
    int[][] del = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int numberOfEnclaves(int[][] grid) {
        
        n = grid.length;
        m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(i, 0, grid, vis);
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                dfs(i, m-1, grid, vis);
            }
        }
        
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                dfs(0, j, grid, vis);
            }
            if(grid[n-1][j] == 1 && !vis[n-1][j]){
                dfs(n-1, j, grid, vis);
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void dfs(int x, int y, int[][] grid, boolean[][] vis){
        vis[x][y] = true;
        
        for(int k = 0; k < 4; k++){
            int i = x + del[k][0];
            int j = y + del[k][1];
            
            if(i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == 1 && !vis[i][j]){
                dfs(i, j, grid, vis);
            }
        }
    }
}
