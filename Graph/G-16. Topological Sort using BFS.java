// GFG Problem Link: https://practice.geeksforgeeks.org/problems/topological-sort/1

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int[] indeg = new int[V];
        
        for(ArrayList<Integer> list : adj){
            for(Integer node : list){
                indeg[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        int[] topo = new int[V];
        int i = 0;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[i++] = node;
            // node is now in our topo sort
            // so now we remove it from indegree
            for(Integer it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        
        return topo;
    }
}
