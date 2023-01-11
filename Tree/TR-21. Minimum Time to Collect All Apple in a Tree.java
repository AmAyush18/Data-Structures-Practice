// LeetCode Profile Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

class Solution {
    List<List<Integer>> adj;
    List<Boolean> apple;
    
    // custom pair class to store time and mark if any apple found in subtree
    class pair{
        int time;
        boolean hasApple;

        public pair(int time, boolean hasApple){
            this.time = time;
            this.hasApple = hasApple;
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new ArrayList<>();
        apple = hasApple;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        // create an adjacency list
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }        

        return dfs(0, 0).time;
    }

    private pair dfs(int node, int parent){
        pair curr = new pair(0, apple.get(node));

        for(Integer neighbour : adj.get(node)){
            // when neighbour is not a parent
            if(neighbour != parent){
                // now the current node becomes parent for neighbour
                pair y = dfs(neighbour, node); 
                if(y.hasApple){
                    curr.time += (2+y.time);
                    curr.hasApple = y.hasApple;
                }
            }
        }
        return curr;
    }
}
