// GFG Problem Link: https://practice.geeksforgeeks.org/problems/ec277982aea7239b550b28421e00acbb1ea03d2c/1

class Solution {
    TreeMap<Integer, Integer> mp;
    ArrayList<Integer> maximumValue(Node node) {
       mp = new TreeMap<>();
       
       dfs(node, 0);
       
       ArrayList<Integer> ans = new ArrayList<>();
       
       for(Integer key : mp.keySet()){
           ans.add(mp.get(key));
       }
       
       return ans;
    }
    
    private void dfs(Node node, int level){
        // base case
        if(node == null){
            return;
        }
        
        if(mp.containsKey(level)){
            int val = Math.max(mp.get(level), node.data);
            mp.put(level, val);
        }else{
            mp.put(level, node.data);
        }
        
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}

class Solution {
    // List to store answer
    ArrayList<Integer> ans;
    ArrayList<Integer> maximumValue(Node node) {
       ans = new ArrayList<>();
       
       // helper method used to find maximum at each level
       helper(node, 0, ans);
       
       return ans;
    }
    
    private void helper(Node node, int level){
        // base case
        if(node == null){
            return;
        }
        // if ans size is greater than level+1 
        // means we have previously encountered an element at this level
        if(ans.size() >= level+1){
            // find the max of previously found element and current element
            int maxVal = Math.max(node.data, ans.get(level));
            ans.set(level, maxVal);  // set value at this level
        }else{
            ans.add(node.data);
        }
        
        // procede to next levels on subtrees to both directions
        helper(node.left, level+1);
        helper(node.right, level+1);
    }
}
