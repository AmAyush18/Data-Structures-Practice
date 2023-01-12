// LeetCode Problem Link: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

class Solution {
    int[] ans;
    List<List<Integer>> adj;
    char[] label;
    int[] counts;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        adj = new ArrayList<>();
        
        // Create an adjacency list
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        // each edge in list should be bidirectional
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        label = labels.toCharArray();
        counts = new int[26];

        dfs(-1, 0);

        return ans;
    }

    private void dfs(int parent, int node){
        int idx = label[node] - 'a';
        int prevCount = counts[idx];
        // after storing the previous count
        // now increment the count
        counts[idx]++;

        for(int child : adj.get(node)){
            // since it's an undirected graph
            if(child != parent){
                // now current node is parent and child is node
                dfs(node, child);
            }
        }
        
        // answer for current node is current count - prev count 
        ans[node] = counts[idx] - prevCount; 
    }
}
