// LeetCode Problem Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Map<Node, Node> mp = new HashMap<>();
        // Step - 1
        Node temp = head;
        Node copyHead = createNode(temp);
        Node currCopy = copyHead;

        while(temp != null){
            mp.put(temp, currCopy);
            currCopy.next = createNode(temp.next);
            currCopy = currCopy.next;
            temp = temp.next;
        }

        temp = head;
        currCopy = copyHead;

        while(temp != null){
            currCopy.random = mp.get(temp.random);
            temp = temp.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }

    Node createNode(Node node){
        
        if(node == null) return null;
        Node newNode=new Node(node.val);
        return newNode;    
    }
}
