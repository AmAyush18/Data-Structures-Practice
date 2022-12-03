//  LeetCode Problem Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

class Solution {
    int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return createBST(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode createBST(int[] A, int bound){
        if(i == A.length || A[i] > bound) return null;
        
        TreeNode root = new TreeNode(A[i++]);
        root.left = createBST(A, root.val);
        root.right = createBST(A, bound);
        return root;
    }
}
