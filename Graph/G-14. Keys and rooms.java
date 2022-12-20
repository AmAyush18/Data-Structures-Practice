// LeetCode Problem Link: https://leetcode.com/problems/keys-and-rooms/description/

// Intuition
// Starting from room 0 if we visit all the rooms whose keys we find on way we would cover each room whose keys are accessible.

// Approach
// Best approach thats comes to mind is DFS... Though BFS would also work.
// After completing the traversal, look in to your visited array to see which room you missed.

// Complexity
// Time complexity:
// O(N) -> For Traversal

// Space complexity:
// O(N) -> Visited Array

// Code
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        
        dfs(0, rooms, vis);

        for(int i = 0; i < n; i++){
            if(!vis[i]) return false;
        }
        return true;
    }

    void dfs(int src, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;

        for(Integer node : adj.get(src)){
            if(!vis[node]){
                dfs(node, adj, vis);
            }
        }
    }
}
