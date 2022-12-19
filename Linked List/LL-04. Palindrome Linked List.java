// LeetCode Problem Link: https://leetcode.com/problems/palindrome-linked-list/description/

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
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null) return true;
        if(head.next.next == null){
            return head.val == head.next.val;
        }
        // find middle
        ListNode mid = findMid(head);

        System.out.println(mid.val);        

        // reverse after middle
        ListNode temp = mid.next;
        mid.next = reverse(temp);


        ListNode temp1 = head;
        ListNode temp2 = mid.next;

        while(temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        // ListNode next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
