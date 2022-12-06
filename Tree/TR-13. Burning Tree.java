// GFG Problem Link: https://practice.geeksforgeeks.org/problems/burning-tree/1

class Solution
{    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        Node tar = new Node(-1);
        Map<Node, Node> parent = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        // BFS for child-parent mapping
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.data == target){
                tar = temp;
            }
            if(temp.left != null){
                parent.put(temp.left, temp);
                q.offer(temp.left);
            }
            if(temp.right != null){
                q.offer(temp.right);
                parent.put(temp.right, temp);
            }
        }
        
        Set<Node> vis = new HashSet<>();
        //BFS for burning tree
        q.add(tar);
        vis.add(tar);   // bcoz the target node burns in the 0th second
        int time = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            boolean burn = false;  // flag variable to keep track if any node actually burnt
            while(sz-- > 0){
                Node temp = q.poll();
                if(!vis.contains(temp)){
                    burn = true;
                    vis.add(temp);
                }
                if(parent.containsKey(temp) && !vis.contains(parent.get(temp))){
                    q.offer(parent.get(temp));
                }
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }
            if(burn){
                time++;
            }
        }
        return time;
    }
}
