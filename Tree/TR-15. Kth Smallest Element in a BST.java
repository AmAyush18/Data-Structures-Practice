// GFG Problem Link: https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

class Solution {
    // Return the Kth smallest element in the given BST
    int count;
    int ans;
    public int KthSmallestElement(Node root, int k) {
        // Write your code here
        int count = 0;
        ans = -1;
        helper(root, k);
        return ans;
    }
    
    void helper(Node root, int k){
        if(root == null){
            return;
        }
        
        helper(root.left, k);
        count++;
        if(k == count){
            ans = root.data;
        }
        helper(root.right, k);
    }
}
