// GFG Problem Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> storeDfs;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
            }
        }
        return storeDfs;
    }
    
    public void dfs(int currNode, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        storeDfs.add(currNode);
        vis[currNode] = true;
        
        ArrayList<Integer> neighbours = adj.get(currNode);
        
        for(Integer neighbour : neighbours){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis);
            }
        }
    }
}
