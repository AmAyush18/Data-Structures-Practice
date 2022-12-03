// LeetCode Problem Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// Check GFG one also because it's slightly different

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null){ 
            return "";             
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        StringBuilder res = new StringBuilder();
        
        //Level Order Traversal
        while(!q.isEmpty()){
            
            TreeNode node = q.poll();
            
            if(node == null){
                res.append("# "); // '#' means 'null' and space means break
                continue;
            }
            
            res.append(node.val + " ");
            
            q.offer(node.left);
            q.offer(node.right);
        }        
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
                
        if(data.length() == 0) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        String[] values = data.split(" "); // we split data with respect to space
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        
        for(int i = 1; i < values.length; i++){
        
            TreeNode parent = q.poll();
            
            if(!values[i].equals("#")){ // if it's not null
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                parent.left = leftNode;
                q.offer(leftNode);
            }
            
            if(!values[++i].equals("#")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                parent.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;                
    }
}
