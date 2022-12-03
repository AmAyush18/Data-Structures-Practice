// GFG Problem Link: https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
    {
        Node successor = null;
        while(root != null){
            
            if(x.data >= root.data){
                root = root.right;
            }
            else{
                successor = root;
                root = root.left;
            }
        }
        
        return successor;
    }
}
