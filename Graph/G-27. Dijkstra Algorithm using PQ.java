// GFG Problem Link: https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

class Pair{
    int distance;
    int node;
    
    Pair(int dist, int _node){
        distance = dist;
        node = _node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        
        PriorityQueue<Pair> pq = 
            new PriorityQueue<>((x, y) -> x.distance - y.distance);
        
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)(1e9);
        }
        
        dist[S] = 0;
        pq.offer(new Pair(0, S));
        
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        
        return dist;
    }
}
