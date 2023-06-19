// Problem Link: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        if(solve(0, adj, new int[n], n, m)) return true;
        return false;
    }
    
    private boolean solve(int node, List<List<Integer>> graph, int[] color, int n, int m){
        if(node == n) return true;
        
        for(int i =1; i <= m; i++){
            if(isSafe(node, graph, color, n, i)){
                color[node] = i;
                if(solve(node+1, graph, color, n, m)) return true;
                
                //otherwise backtrack
                color[node] = 0;
            }
        }
        return false;
    }
    
    private boolean isSafe(int node, List<List<Integer>> graph, int[] color, int n, int col){
        // cehck if any adjacent node has same color
        for(int it : graph.get(node)){
            if(color[it] == col) return false;
        }
        return true;
    }
}
