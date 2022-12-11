// LeetCode Problem Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1

class Solution {
    int maxi;
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        maxSum(root);
        return maxi;
    }

    int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = Math.max(0, maxSum(root.left));
        int rightSum = Math.max(0, maxSum(root.right));
        
        maxi = Math.max(maxi, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
