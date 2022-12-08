// GFG Problem Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(detectCycle(i, -1, adj, vis)){
                    return true;   
                }
            }
        }
        return false;
    }
    
    boolean detectCycle(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src] = true;
        
        for(int node : adj.get(src)){
            if(!vis[node]){
                if(detectCycle(node, src, adj, vis)) return true;
            }else if(parent != node){
                return true;
            }
        }
        return false;
    }
}
