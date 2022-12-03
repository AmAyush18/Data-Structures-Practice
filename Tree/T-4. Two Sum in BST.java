// LeetCode Problem Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1

// Implementing a single Iterator Class so that we can reuse it for both next and befor
// Recommended for Interview
class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    // reverse -> true -> before
    // reverse -> false -> next
    boolean reverse = true;
    
    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    
    boolean hasNext() {
        return !st.isEmpty();
    }
    
    int next(){
        TreeNode temp = st.pop();
        if(!reverse){
            pushAll(temp.right);
        } 
        else{
            pushAll(temp.left);
        }
        return temp.val;
    }
    
    void pushAll(TreeNode node){
        for( ; node!= null; ){
            st.push(node);
            if(reverse){
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
    
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        
        // Two Pointers
        int i = l.next();
        int j = r.next();
        
        while(i < j){
            int temp = i + j;
            if(temp == k){
                return true;
            }
            else if(temp > k){
                if(!r.hasNext()) return false;
                j = r.next();
            }
            else{
                if(!l.hasNext()) return false;
                i = l.next();
            }
        }
        return false;
    }
    
}
