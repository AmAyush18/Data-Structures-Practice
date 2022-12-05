// LeetCode Problem Link: https://leetcode.com/problems/count-complete-tree-nodes/

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        
        if(lh == rh) return (1<<lh) - 1;  // 2^lh
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int getLeftHeight(TreeNode node){
        int hght = 0;
        while(node != null){
            hght++;
            node = node.left;
        }
        return hght;
    }
    
    public int getRightHeight(TreeNode node){
        int hght = 0;
        while(node != null){
            hght++;
            node = node.right;
        }
        return hght;
    }
}
