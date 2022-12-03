//GFG Problem Link: https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    if(root == null) return;
	    
	    Queue<Node> q = new LinkedList<>();
	    q.offer(root);
	    
	    while(!q.isEmpty()){
	        
	        Node node = q.poll();
	        if(node == null){
	            A.add(-1);
	            continue;
	        }
	        
	        A.add(node.data);
	        
	        q.offer(node.left);
	        q.offer(node.right);
	    }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        if(A.size() == 0) return null;
        Node root = new Node(A.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i < A.size(); i++){
            Node node = q.poll();
            if(A.get(i) != -1){
                Node leftNode = new Node(A.get(i));
                node.left = leftNode;
                q.offer(leftNode);
            }
            
            if(A.get(++i) != -1){
                Node rightNode = new Node(A.get(i));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }
};
