// Problem Link: https://practice.geeksforgeeks.org/problems/huffman-encoding3345/0

class TreeNode implements Comparable<TreeNode>{
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public int compareTo(TreeNode curr){
        if(this.data > curr.data) return 1;
        
        if(this.data < curr.data) return -1;
        
        return 0;
    }
}

class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<TreeNode> pq = new PriorityQueue<>();
        
        for(int ele : f){
            pq.offer(new TreeNode(ele));
        }
        
        while(pq.size() > 1){
            
            TreeNode left = pq.poll();
            TreeNode right = pq.poll();
            
            TreeNode newNode = new TreeNode(left.data + right.data);
            newNode.left = left;
            newNode.right = right;
            
            pq.offer(newNode);
        }
        
        TreeNode root = pq.poll();
        ArrayList<String> ans = new ArrayList<>();
        String temp = "";
        
        traverse(root, ans, temp);
        
        return ans;
    }
    
    public void traverse(TreeNode root, ArrayList<String> ans, String temp){
        
        if(root.left == null && root.right == null){
            ans.add(temp);
            return;
        }
        
        //Left Traversal
        traverse(root.left, ans, temp + "0" );
        
        //Right Traversal
        traverse(root.right, ans, temp + "1");

    }
    
}
