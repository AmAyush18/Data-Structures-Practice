//  LeetCode Problem Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

class Solution {
    int val;
    public int maxAncestorDiff(TreeNode root) {
        val = 0;
        dfs(root, root.val, root.val);
        return val;
    }

    void dfs(TreeNode node, int max, int min){
        
        // If current val is greater than previous ones it'll replace max
        max = Math.max(max, node.val);
        // If current val is smaller than previous ones it'll replace min
        min = Math.min(min, node.val);

        // value of val(ans) gets updated if new max is found
        val = Math.max(val, max-min);

        if(node.left != null){
            dfs(node.left, max, min);
        }
        if(node.right != null){
            dfs(node.right, max, min);
        }
    }
}


// Solution to the problem on GFG
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1

class Tree
{
    int val;
    int maxDiff(Node root)
    {
        val = Integer.MIN_VALUE;
        dfs(root);
        return val;
    }

    int dfs(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int leftMin = dfs(root.left);
        int rightMin = dfs(root.right);
        int realMin = Math.min(leftMin, rightMin);
        
        int res = root.data - realMin;
        val = Math.max(res, val);
        
        return Math.min(root.data, realMin);
    }
}
