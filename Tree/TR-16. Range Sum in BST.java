// LeetCode Problem Link: https://leetcode.com/problems/range-sum-of-bst/description/

// Intuition
// Think of it as a binary search... Just with one change that you're not actually looking for a value but for a range of values.

// Approach
// Just follow the similar strategy as you would follow in case of Binary Search that is discard halves if your current node falls out of range.

// Complexity
// Time complexity:
// O(N) -> In worst case all your elements might fall in range
// Space complexity:
// O(N) -> Recursive Stack Space
// Code

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        if(root.val < low){   // if current node value is less than low than move it to greater side that is right side
            return rangeSumBST(root.right, low, high);
        }else if(root.val > high){  // if current node value is greater than high than move it to lower side that is left side
            return rangeSumBST(root.left, low, high);
        }else{  // if it's in range add the current value and repeat for left and right subtree
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}

// GFG Problem Link: https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1

class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int low, int high)
    {
        //Your code here
        if(root == null) return 0;
        
        if(root.data < low){
            return getCount(root.right, low, high);
        }
        if(root.data > high){
            return getCount(root.left, low, high);
        }
        
        return 1 + getCount(root.left, low, high) + getCount(root.right, low, high);
    }
}
