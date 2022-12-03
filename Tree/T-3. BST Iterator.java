// LeetCode Link: https://leetcode.com/problems/binary-search-tree-iterator/

class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node){
        for(; node != null; node = node.left)
            stack.push(node);
    }
}
