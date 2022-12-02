// GFG Qsn Link:- https://practice.geeksforgeeks.org/problems/largest-bst/1

// Helper Data Structure to keep track of smallest node, largest node and current largest BST
class NodeValue{
        public int minNode, maxNode, maxSize;
        
        NodeValue(int minNode, int maxNode, int maxSize){
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return largestBSTHelper(root).maxSize;
    }
    
    static NodeValue largestBSTHelper(Node root){
        // An empty tree is a BST of size 0
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        //Get values from left and right subtree of current tree
        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);
        
        //Current node is greater than max in left AND smaller than min in right
        // than it is a valid BST
        if(left.maxNode < root.data && root.data < right.minNode){
            // It is a BST
            return new NodeValue(Math.min(root.data, left.minNode), 
                Math.max(root.data, right.maxNode), 1 + left.maxSize + right.maxSize);
        }
        
        // Otherwise return [int_min, int_max, max(l.sz, r.sz)] so that parent can't be a valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 
        Math.max(left.maxSize, right.maxSize));
        
    }
    
}
