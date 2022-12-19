// GFG Problem Link: https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1

class LinkedList
{
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        if(head1.data <= head2.data){
            return solve(head1, head2);
        }
        
        return solve(head2, head1);
    }    
    
    Node solve(Node first, Node second){
        
        Node curr1 = first;
        Node curr2 = second;
        Node next1 = first.next;
        Node next2 = curr2.next;
        
        while(next1 != null && curr2 != null){
            // We are checking can we insert in between curr and next
            if((curr2.data >= curr1.data) 
                && (curr2.data <= next1.data)){
                    
                // add node in the middle
                curr1.next = curr2;
                next2 = curr2.next;
                curr2.next = next1;
                
                // update pointers
                curr1 = curr2;                
                curr2 = next2;
            }else{
                curr1 = next1;
                next1 = curr1.next;
            }
        }
        
        if(next1 == null && curr2 != null){
            curr1.next = curr2;
        }
        
        return first;
    }
}
