// LeetCode Problem Link: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

class Solution {
    final int mod = 1000000007;
    long sum = 0;
    long diff = 0;
    public int maxProduct(TreeNode root) {
        totalSum(root);
        return maxProd(root);
    }

    // method to find total sum of all nodes
    public void totalSum(TreeNode root){
        if(root == null) return;
        sum += root.val;
        totalSum(root.left);
        totalSum(root.right);
    }
    // method that returns max product
    public int maxProd(TreeNode root){
        rootSum(root);
        return (int)(diff%mod);
    }

    // method to find sum of particular subtree
    public long rootSum(TreeNode root){
        if(root == null){
            return 0L;
        }

        long left = rootSum(root.left);
        diff = Math.max((sum-left)*left, diff);   // sum-left -> right

        long right = rootSum(root.right);
        diff = Math.max((sum-right)*right, diff);  // sum - right -> left

        long currSum = left + right + root.val;
        diff = Math.max((sum-currSum)*currSum, diff);

        // sum of subtree with root as 'root'
        return currSum;
    }
}
