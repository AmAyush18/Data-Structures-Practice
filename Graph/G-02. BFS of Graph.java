// GFG Problem Link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    // Function to return Breadth First Traversal of given graph.
    ArrayList<Integer> storeBfs;
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        storeBfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                
                vis[i] = true;
                
                while(!q.isEmpty()){
                    
                    Integer currNode = q.poll();
                    storeBfs.add(currNode);
                    
                    for(Integer it : adj.get(currNode)){
                        if(!vis[it]){
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        
        return storeBfs;
    }
}
