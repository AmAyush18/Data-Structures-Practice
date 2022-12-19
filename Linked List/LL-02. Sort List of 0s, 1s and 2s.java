// GFG Problem Link: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;
        
        Node curr = head;
        while(curr != null){
            
            int value = curr.data;
            
            if(value == 0){
                zeroTail.next = curr;
                zeroTail = curr;
            }
            else if(value == 1){
                oneTail.next = curr;
                oneTail = curr;
            }
            else if(value == 2){
                twoTail.next = curr;
                twoTail  = curr;
            }
            curr = curr.next;
        }
        
        // merge three sublists
        if(oneHead.next != null){
            zeroTail.next = oneHead.next;
        }
        else{
            zeroTail.next = twoHead.next;
        }
        
        oneTail.next = twoHead.next;
        twoTail.next = null;
        
        return zeroHead.next;
    }
}
