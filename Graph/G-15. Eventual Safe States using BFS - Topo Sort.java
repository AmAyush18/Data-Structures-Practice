// GFG Problem Link: https://practice.geeksforgeeks.org/problems/eventual-safe-states/1

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> original) {
        
        int[] indeg = new int[V];
        
        List<List<Integer>> reversed = reverseGraph(original);
        
        for(int i = 0; i < V; i++){
            for(Integer node : reversed.get(i)){
                indeg[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indeg[i] == 0) q.add(i);
        }
        
        List<Integer> safeNodes = new ArrayList<>();
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            safeNodes.add(node);
            
            for(Integer it : reversed.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    
    List<List<Integer>> reverseGraph(List<List<Integer>> adj){
        List<List<Integer>> graph = new ArrayList<>();
        
        int V = adj.size();
        
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            for(Integer node : adj.get(i)){
                graph.get(node).add(i);
            }
        }
        return graph;
    }
}
