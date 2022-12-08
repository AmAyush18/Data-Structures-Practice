// LeetCode Problem Link: https://leetcode.com/problems/surrounded-regions/description/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1


// Observations: 
// 1. Set of 'O' connected  to the boundry cannot be surrounded
// 2. If not connected to boundary then they are surely surrounded by X

// Algorithm:
// start from boundary O's and mark them they will not be converted using DFS(preffered)/BFS


class Solution {
    int n, m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        // Check each boundaries for O's
        // Top Boundary && Bottom Boundary
        for(int i = 0; i < m; i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(0,i,board,vis);
            }
            if(board[n-1][i]=='O' && !vis[n-1][i]){
                dfs(n-1,i,board,vis);
            }
        }
        // Left Boundary && Right Boundary
        for(int i = 0; i < n; i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(i,0,board,vis);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                dfs(i,m-1,board,vis);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                    // System.out.println("Inside"+i+" "+j);
                }
                // System.out.print(vis[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] delta = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    void dfs(int x, int y, char[][] board, boolean[][] vis){
        vis[x][y] = true;

        for(int k = 0; k < 4; k++){
            int i = x + delta[k][0];
            int j = y + delta[k][1];
            if(i >= 0 && j >= 0 && i < n && j < m && !vis[i][j] && board[i][j] == 'O'){
                dfs(i, j, board, vis);
            }
        }
    }
}

