// LeetCode problem link : https://leetcode.com/problems/all-paths-from-source-to-target/description/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         // make the List of List so we can store the result
        List<List<Integer>> result = new LinkedList<>();
        // make the List for current path so we can start finding paths
        List<Integer> curr = new ArrayList<>();
        // add the first node to current List
        curr.add(0);
        // start the dfs 
        dfs(0, curr, graph, graph.length - 1, result);
        // return the result
        return result;
    }

    // function of dfs search
    private void dfs(int src, List<Integer> curr, int graph[][], int dest, List<List<Integer>> res){
        // if src == dest mean we find the correct path so we have to add it to 
        // result List
        if(src == dest){
            res.add(new ArrayList<>(curr));
            return;
        }
        // get the node from graph to travers forward
        for(int a: graph[src]){
            // add the node to current list so we can travers
            curr.add(a);
            // call the dfs for current node
            dfs(a, curr, graph, dest, res);
            // remove the current node from when it's traversed
            curr.remove(curr.size() - 1);
        }
    }
}
