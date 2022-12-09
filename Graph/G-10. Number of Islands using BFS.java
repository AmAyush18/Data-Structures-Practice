// GFG Problem Link: https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    int n, m;
    int[][] del = {{1,0},{0,1},{-1,0},{0,-1},{-1,1},{1,-1},{-1,-1},{1,1}};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }

    public void bfs(int a, int b, char[][] grid, boolean[][] vis){
    
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,b});
        vis[a][b] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int k = 0; k < 8; k++){
                int i = x + del[k][0];
                int j = y + del[k][1];
    
                if(i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == '1' && !vis[i][j]){
                    vis[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }
    }
}
