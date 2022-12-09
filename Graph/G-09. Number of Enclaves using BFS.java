GFG Problem Link: 
LeetCode Problem Link: 

// Solved using multi-source BFS

class Solution {
    
    int numberOfEnclaves(int[][] grid) {
        int n, m;
        
        n = grid.length;
        m = grid[0].length;
        int[][] del = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        // Adding all the sources in a Queue for bfs
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1){
                q.add(new int[]{i,0});
                vis[i][0] = true;
            }
            if(grid[i][m-1] == 1){
                q.add(new int[]{i,m-1});
                vis[i][m-1] = true;
            }
        }
        
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1){
                q.add(new int[]{0,j});
                vis[0][j] = true;
            }
            if(grid[n-1][j] == 1){
                q.add(new int[]{n-1,j});
                vis[n-1][j] = true;
            }
        }
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int k = 0; k < 4; k++){
                int i = x + del[k][0]
                int j = y + del[k][1];   
                if(i >= 0 && j >= 0 && i < n && j < m && !vis[i][j] && grid[i][j] == 1){
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]) count++;
            }
        }
        
        return count;
    }
}
