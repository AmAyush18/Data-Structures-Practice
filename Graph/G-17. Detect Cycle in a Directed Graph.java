//  GFG Problem Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        List<Integer> topo = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[V];
        
        for(int i = 0; i < V; i++){
            for(Integer node : adj.get(i)){
                indeg[node]++;
            }
        }
        
        for(int i = 0; i < V; i++){
            if(indeg[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo.add(node);
            
            for(Integer it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
            
        }
        
        return topo.size() != V;
    }
}
