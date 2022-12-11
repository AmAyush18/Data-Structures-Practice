// GFG Problem Link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(dfs(i, 0, color, adj) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean dfs(int curr, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[curr] = col;
        
        for(int node : adj.get(curr)){
            if(color[node] == -1){
                if(dfs(node, 1 - col, color, adj) == false){
                    return false;
                }
            }
            else if(color[node] == col){
                return false;
            }
        }
        return true;
    }
}
