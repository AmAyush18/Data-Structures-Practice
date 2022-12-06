// LeetCode Problem Link: https://leetcode.com/problems/odd-even-linked-list/description/

Intuition
Firstly try to seperate the list of odd and even indices.

Approach
Best way to do so that is by using two-pointers.

Complexity
Time complexity:
O(N)

Space complexity:
O(1)

Code
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddRoot = new ListNode(-1);
        ListNode evenRoot = new ListNode(-1);
        ListNode currOdd = oddRoot;
        ListNode currEven = evenRoot;
        ListNode temp = head;
        
        int it = 1;  // iterator

        // Seperating the Linked List
        while(temp != null){
            if((it&1) == 1){ // odd index
                currOdd.next = temp;
                currOdd = currOdd.next;
            }else{  // even index
                currEven.next = temp;
                currEven = currEven.next;
            }
            it++;
            temp = temp.next;
        }
        currEven.next = null;
        currOdd.next = evenRoot.next;              
        return oddRoot.next;
    }
}
