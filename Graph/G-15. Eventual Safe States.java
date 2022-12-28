// LeetCode Problem Link: https://leetcode.com/problems/find-eventual-safe-states/description/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/eventual-safe-states/1

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int V = graph.length;
        boolean[] vis = new boolean[V];        
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfsCheck(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(check[i]) safeNodes.add(i);
        }

        return safeNodes;
    }

    boolean dfsCheck(int node, int[][] adj, boolean[] vis, boolean[] pathVis, boolean[] check){

        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for(int curr : adj[node]){
            if(!vis[curr]){
                if(dfsCheck(curr, adj, vis, pathVis, check)){
                    return true;
                }
            }
            else if(pathVis[curr]){
                return true;
            }
        }
        pathVis[node] = false;
        check[node] = true;

        return false;
    }
}
