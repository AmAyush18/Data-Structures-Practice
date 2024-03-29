// LeetCode Problem Link: https://leetcode.com/problems/binary-tree-paths/

class Solution {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        ArrayList<Integer> sb = new ArrayList<>();
        
        getPath(root, sb);
        
        return res;
    }
    
    public void getPath(TreeNode root, ArrayList<Integer> sb){
        if(root == null)
            return;
        
        sb.add(root.val);
        getPath(root.left, sb);
        
        if(root.left == null && root.right == null){
            addPath(sb);
        }
        
        getPath(root.right, sb);
        sb.remove(sb.size()-1);
    }
    
    public void addPath(ArrayList<Integer> sb){
        StringBuilder tempString = new StringBuilder();
        for(int i = 0; i < sb.size(); i++){
            if(i == sb.size() - 1) tempString.append(sb.get(i));
            else tempString.append(sb.get(i) + "->");
        }
        res.add(tempString.toString());
    }
}
