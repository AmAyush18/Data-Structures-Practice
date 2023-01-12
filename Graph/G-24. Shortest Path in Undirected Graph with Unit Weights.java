// GFG Problem Link: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

class Solution {
    List<List<Integer>> adj;
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : adj.get(node)){
                if(dist[node] + 1 < dist[neighbour]){
                    dist[neighbour] = 1 + dist[node];
                    q.add(neighbour);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
