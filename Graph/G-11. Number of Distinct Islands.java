//  GFG Problem Link: https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

// Solved using DFS but BFS can also be used
// Use set to keep track of steps you have taken
 
 class Solution {
    
    Set<ArrayList<String>> set;
    int n, m;
    int[][] del = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int countDistinctIslands(int[][] grid) {
        
        n = grid.length;
        m = grid[0].length;
        
        set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<String> arr = new ArrayList<>();
                    int[] base = new int[]{i,j};
                    dfs(i,j,grid,vis,arr, base);
                    set.add(arr);
                }
            }
        }
        
        return set.size();
    }
    
    void dfs(int x, int y, int[][] grid, boolean[][] vis, ArrayList<String> arr, int[] base){
        vis[x][y] = true;
        String pos = toString(x-base[0], y-base[1]);
        arr.add(pos);
        
        for(int k = 0; k < 4; k++){
            int i = x + del[k][0];
            int j = y + del[k][1];
            
            if(i >= 0 && j >= 0 && i < n && j < m && !vis[i][j] && grid[i][j] == 1){
                dfs(i, j, grid, vis, arr, base);
            }
        }
        
    }
    
    String toString(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    
} 
