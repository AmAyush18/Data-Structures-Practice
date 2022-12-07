// GFG Problem Link: https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
// LeetCode Problem Link: https://leetcode.com/problems/rotting-oranges/

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        // first we insert indices of all rotten oranges
        int countFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, 0});  // index and time at which they will rotten
                    vis[i][j] = true;
                }
                
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }
        
        int[][] dir = {{1,0}, {0,-1}, {0,1}, {-1, 0}};
        int time = 0;
        int countRotting = 0;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int tm = curr[2];
            time = Math.max(tm, time);
            
            for(int k = 0; k < 4; k++){
                int i = x + dir[k][0];
                int j = y + dir[k][1];
                if(i >= 0 && j >= 0 && i < n && j < m
                   && grid[i][j] == 1 && !vis[i][j]){
                    q.offer(new int[]{i, j, tm+1});
                    vis[i][j] = true;
                    countRotting++;
                }
            }
        }
        
        if(countRotting == countFresh){
            return time;
        }
        return -1;
    }
} 
