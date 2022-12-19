// LeetCode Problem Link: https://leetcode.com/problems/find-if-path-exists-in-graph/description/

// Intuition
// Starting from source, if we visit the nodes till max depth and at some point found destination means we have a path. So DFS is our goto solution for this question. BFS can also be used if you like it more.

// Complexity
// Time complexity:
// O(n) -> Bcoz we visit each node at max once
// O(edges) -> for creating the adjacency list

// Space complexity:
// O(n) -> Visited Array
// O(V+E) -> Adjacency List

// Code
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        dfs(source, adj, vis);

        return vis[destination];
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){

        vis[src] = true;

        for(Integer node : adj.get(src)){
            if(!vis[node]){
                dfs(node, adj, vis);
            }
        }
    }
}
