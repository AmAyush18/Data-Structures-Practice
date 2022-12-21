// LeetCode Problem Link: https://leetcode.com/problems/sliding-window-maximum/description/

// Intuition
// Keep useful elements in a window and remove useless ones.So that the first element present in each window is the maximum one.
// Also keep index not the value other wise you gotta use pair and that will just make life harder.

// Approach
// Using Deque to solve. We add usefull elements (elements to left of which there are no smaller elements than it).
// Go through solution you'll understand it pretty well/

// Complexity
// Time complexity:
// O(N) - Just doing single traversal through array.

// Space complexity:
// O(k) - There are no more than k elements at a time in Deque

// Code
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int n = nums.length;

        // adding useful elements for the first window 
        while(i < k && i < n){
            // For every element the previous smaller elements are useless so removing them deque
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                // removing from back
                q.pollLast();
            }
            // Adding new element at back
            q.offerLast(i);
            i++;
        }
        int[] ans = new int[n-k+1];
        int j = 0;

        for( ; i < n; i++){
            // adding element to answer 
            ans[j++] = nums[q.peek()]; 

            // removing elements which are out of this window
            while(!q.isEmpty() && q.peek() <= i - k){
                q.pollFirst();
            }
            // again removing useless elements
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
        }
        ans[j] = nums[q.peek()];
        return ans;
    }
}
