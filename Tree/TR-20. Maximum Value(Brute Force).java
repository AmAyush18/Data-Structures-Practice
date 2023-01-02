// GFG Problem Link: https://practice.geeksforgeeks.org/problems/ec277982aea7239b550b28421e00acbb1ea03d2c/1

// Brute Force Approach - Gives TLE
class Solution {
    Map<Integer, Integer> mp;
    ArrayList<Integer> maximumValue(Node node) {
       mp = new HashMap<>();
       
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
        
        if(!mp.containsKey(level)){
            mp.put(level, node.data);
        }else{
            int val = Math.max(mp.get(level), node.data);
            mp.put(level, val);
        }
        
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}

// Brute Force Approach - 2 - Gives TLE
class Solution {
    ArrayList<Integer> ans;
    ArrayList<Integer> maximumValue(Node node) {
       ans = new ArrayList<>();
       
       helper(node, 0, ans);
       
       return ans;
    }
    
    private void helper(Node node, int level, ArrayList<Integer> ans){
        // base case
        if(node == null){
            return;
        }
        
        if(ans.size() >= level+1){
            int maxVal = Math.max(node.data, ans.get(level));
            ans.set(level, maxVal);
        }else{
            ans.add(node.data);
        }
        
        helper(node.left, level+1, ans);
        helper(node.right, level+1, ans);
    }
}
