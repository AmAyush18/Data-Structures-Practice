// LeetCode Problem Link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/

// Intution is that while doing level-order traversal... 
// the last node that we encounter as null must be the very last node we ever encounter...

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean isEnd = false;  // to keep track that did we encounter null till now or not
        
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while(!que.isEmpty()){
            TreeNode currentNode = que.poll();
            
            if(currentNode == null){
                isEnd = true; // if we encounter null -> we mark it as our expected end is met
            }
            else{
                // if our currentNode is not null but we have already encountered any null node previously that means it's false
                if(isEnd) 
                    return false;
                que.offer(currentNode.left);
                que.offer(currentNode.right);
            }
        }
        return true;
    }
}
