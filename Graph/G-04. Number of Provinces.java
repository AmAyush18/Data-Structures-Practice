// LeetCode Problem Link: https://leetcode.com/problems/number-of-provinces/description/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/number-of-provinces/1

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                provinces++;
                dfs(i, adj, vis);
            }
        }
        return provinces;
    }

    void dfs(int currNode, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[currNode] = true;

        for(Integer node : adj.get(currNode)){
            if(!vis[node]){
                dfs(node, adj, vis);
            }
        }
    }
}
