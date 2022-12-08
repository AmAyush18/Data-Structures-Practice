// GFG Problem Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
  
  class Solution {
    // Function to detect cycle in an undirected graph.
    
    class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(detectCycle(i, V, adj, vis)) return true;
            }
        }
        return false;
    }
    
    boolean detectCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = true;
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                Pair curr = q.poll();
                int node = curr.node;
                int parent = curr.parent;
                
                for(int ele : adj.get(node)){
                    if(!vis[ele]){
                        q.add(new Pair(ele, node));
                        vis[ele] = true;
                    }else if(ele != parent){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
} 
