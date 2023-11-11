// https://leetcode.com/problems/design-graph-with-shortest-path-calculator/

class Graph {
    // pair is used to store (node,dist)
    class pair{
        int a, b;
        pair(int a, int b){
            this.a=a;
            this.b=b;
        }
    }
    // make an adjacency list to store the graph....i.e edge info
    ArrayList<ArrayList<pair>>adj;
    public Graph(int n, int[][] edges) {
        // initialise the list
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        // add edges to the list
        for(int [] edge :edges)
        addEdge(edge);
    }
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new pair(edge[1],edge[2]));
    }
    public int shortestPath(int node1, int node2) {
        // apply dijkstra algo
        int []dist=new int[adj.size()];
        for(int i=0;i<dist.length;i++){
            dist[i]=100000000;
        }
        dist[node1]=0;
        PriorityQueue<pair>pq=new PriorityQueue<>((x,y)->x.a-y.b);
        pq.offer(new pair(node1,0));
        while(!pq.isEmpty()){
            pair p=pq.poll();
            for(int i=0;i<adj.get(p.a).size();i++){
                int node=adj.get(p.a).get(i).a, d=adj.get(p.a).get(i).b;
                if(dist[node]>dist[p.a]+d){
                    dist[node]=dist[p.a]+d;
                    pq.offer(new pair(node,dist[node]));
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        return dist[node2]==100000000 ? -1 :dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
