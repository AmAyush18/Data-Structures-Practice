// GFG Problem Link: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

class Solution {
    List<List<int[]>> adj;
	public int[] shortestPath(int N,int M, int[][] edges) {
        // Adjacency List
        adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        // do the topo sort and store in stack
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                topoSort(i, vis, st);
            }
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, (int)(1e9));
        dist[0] = 0;  // bcoz 0 is our src and src to src is 0 distance
        
	// T.C: O(N + M)
	// we do it this way to make sure that before going to any node
	// we have computed the answer for the node that could lead to this node
        while(!st.isEmpty()){
            int node = st.pop();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int v = adj.get(node).get(i)[0];
                int wt = adj.get(node).get(i)[1];
                
                if(dist[node] + wt < dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            if(dist[i] == (int)(1e9)){
                dist[i] = -1;
            }
        }
        
        return dist;
	}
	// Intution for doing topoSort is to find the order of reachibility
	// T.C: O(N)
	private void topoSort(int node, boolean[] vis, Stack<Integer> st){
	    vis[node] = true;
	    
	    for(int[] neighbour : adj.get(node)){
	        int curr = neighbour[0];
	        if(!vis[curr]){
	            topoSort(curr, vis, st);
	        }
	    }
	    st.push(node);
	}
}
