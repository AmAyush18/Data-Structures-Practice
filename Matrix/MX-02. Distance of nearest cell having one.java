//  GFG Problem Link: https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        int dist = 0;
        int[][] ans = new int[n][m];
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        // BFS
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz -- > 0){
                int[] idx = q.poll();
                int x = idx[0];
                int y = idx[1];
                ans[x][y] = dist;
                for(int[] dir: directions){
                    int i = x+dir[0];
                    int j = y+dir[1];
                    if(i >= 0 && j >= 0 && i < n && j < m && !vis[i][j]){
                        q.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}
