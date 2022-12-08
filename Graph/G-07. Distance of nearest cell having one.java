//  GFG Problem Link: https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
// Similar LeetCode Problem Link: https://leetcode.com/problems/01-matrix/

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        
        int[][] delta = {{1,0}, {0,1}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }
        
        // BFS for calculating minimum distance
        
        while(!q.isEmpty()){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int dis = curr[2];
                ans[x][y] = dis;
                for(int k = 0; k < 4; k++){
                    int i = x + delta[k][0];
                    int j = y + delta[k][1];
                    if(i>=0 && j>=0 && i<n && j<m && !vis[i][j] && grid[i][j]==0){
                        q.add(new int[]{i, j, dis+1});
                        vis[i][j] = true;
                    }
                }
        }
        return ans;
    }
}
