// LeetCode Problem Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/

// Algorithm
// Step-1: Clone the Linked List
// Step-2: Add clone nodes in-between original nodes
// Step-3: Set the random pointers
// Step-4: Seperate the links between original and cloned list


class Solution {
    public Node copyRandomList(Node head) {        
        // step-1 && step-2 combined
        duplicate(head);

        // step-3 
        Node curr = head;
        while(curr != null){
            if(curr.next != null){
                curr.next.random = curr.random != null ? curr.random.next : null;
            }
            curr = curr.next.next;
        }
        // step-4
        return seperate(head);        
    }

    void duplicate(Node head){
        Node curr = head;

        while(curr != null){
            Node temp = curr.next;
            // creating a new Node and adding it in-between original list
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
    }

    Node seperate(Node head){
        if(head == null) return head;

        Node original = head;
        Node copy = head.next;
        Node temp = copy;

        while(original != null){
            original.next = original.next.next;
            copy.next = copy.next != null ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
        }

        return temp;        
    }
}
