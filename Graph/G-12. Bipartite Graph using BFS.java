// GFG Problem Link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1
// LeetCode Problem Link: https://leetcode.com/problems/is-graph-bipartite/

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(check(i, V, adj, color) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        
        while(!q.isEmpty()){
            
            Integer curr = q.poll();
            
            for(int node : adj.get(curr)){
                // if the adjacent node is yet not colored
                // we give it the opposite color of of current node
                if(color[node] == -1){
                    color[node] = 1 - color[curr];
                    q.add(node);
                }
                // if the adjacent node is having same color
                // it means someone colored it on some other path hence false
                else if(color[node] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}
