// LeetCode Problem Link:- https://leetcode.com/problems/recover-binary-search-tree/submissions/
// GFG Problem Link:- https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1

class Solution {
    
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;
    
    public void recoverTree(TreeNode root) {
        
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        
        // If swapped are not adjacents
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        // If swapped are adjacents
        else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        
    }
    
    public void inorder(TreeNode root){
        
        if(root == null) return;
        
        inorder(root.left);
        
        if(prev != null && (root.val < prev.val)){
            // If this is first voilation, mark these two nodes as
            // 'first' and 'middle'
            if(first == null){
                first = prev;
                middle = root;
            }
            
            // If this is second violation, mark this node as last
            else
                last = root;
        }
        
        // Mark this current node as prev
        prev = root;
        inorder(root.right);
    }
}
