// LeetCode Problem Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

class Solution {
    // Node Class
    class Node {
        List<Integer> children;

        public Node(List<Integer> children){
            this.children = children;
        }
    }

    private int ans = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++){
            int managerIdx = manager[i];
            if(i == headID){
                continue;
            }
            Node managerNode = nodes[managerIdx];
            if(managerNode == null){
                managerNode = new Node(new ArrayList<>());
            }
            managerNode.children.add(i);
            nodes[managerIdx] = managerNode;
        }
        traverse(nodes, informTime, headID, 0);
        return ans;
    }

    void traverse(Node[] nodes, int[] informTime, int current, int elapsed){
        if(nodes[current] == null){
            ans = Math.max(ans, elapsed);
            return;
        }

        Node currentNode = nodes[current];
        for(int i = 0; i < currentNode.children.size(); i++){
            int childIdx = currentNode.children.get(i);
            traverse(nodes, informTime, childIdx, elapsed + informTime[current]);
        }
    }

}
