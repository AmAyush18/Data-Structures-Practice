// GFG Problem Link: https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/0

class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int k) 
    { 
        // Write your code here
        int ans = Integer.MAX_VALUE;
        while(root != null){
            ans = Math.min(ans, (int)Math.abs(root.data - k));
            
            if(root.data < k) root = root.right;
            else root = root.left;
        }
        
        return ans;
    } 
}
