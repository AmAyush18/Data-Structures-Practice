// LeetCode Problem Link: https://leetcode.com/problems/symmetric-tree/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        
        if(left.val != right.val){
            return false;
        }
        
        return isSymmetric(left.left, right.right)
            && isSymmetric(left.right, right.left);
    }
}
