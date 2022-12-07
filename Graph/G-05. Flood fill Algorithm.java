// GFG Problem Link: https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1

// Using DFS
class Solution
{
    int n, m;
    int[][] del = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        n = image.length;
        m = image[0].length;
        int initColor = image[sr][sc];
        int[][] ans = image.clone();

        dfs(sr, sc, image, ans, initColor, newColor);
        return ans;
    }
    
    public void dfs(int row, int col, int[][] img, int[][] ans, int initColor, int newColor){
        ans[row][col] = newColor;
        
        for(int k = 0; k < 4; k++){
            int i = row + del[k][0];
            int j = col + del[k][1];
            if(i >= 0 && j >= 0 && i < n && j < m && img[i][j] == initColor && ans[i][j] != newColor){
                dfs(i, j, img, ans, initColor, newColor);
            }
        }
    }
}
