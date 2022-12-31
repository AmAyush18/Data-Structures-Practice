// https://leetcode.com/problems/unique-paths-iii/description/

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startRow = 0, startCol = 0;
        int zeroCount = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                // counting number of zeroes so that while traversing 
                // we can keep track if all blocks are visited or not
                if(grid[row][col] == 0){
                    zeroCount++;
                }
                // if we found 1 means this is our start point
                else if(grid[row][col] == 1){
                    startRow = row;
                    startCol = col;
                }
            }
        }

        return dfs(startRow, startCol, grid, zeroCount);
    }

    private int dfs(int row, int col, int[][] grid, int zeroCount){
        // base case to check if we are at valid position
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1){
            return 0;
        }

        // if we found our ending square
        if(grid[row][col] == 2){
            // if zeroCount == -1 means we have reached ending square by consuming all the non-obstacle paths
            return zeroCount == -1 ? 1 : 0;
        }

        // mark the current grid as -1 so that we don't visit it in current traversal
        grid[row][col] = -1;
        // decrease the zeroCount bcoz we have visited this current square
        zeroCount--;

        // to traverse all for directions
        int[][] delta = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        // to store number of paths
        int totalPaths = 0;
        for(int[] del : delta){
            totalPaths += dfs(row + del[0], col + del[1], grid, zeroCount);
        } 

        // backtrack so that it doesn't blocks while finding other possibilities
        grid[row][col] = 0;
        zeroCount++;

        return totalPaths;
    }
}
