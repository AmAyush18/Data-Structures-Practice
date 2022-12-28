// LeetCode Problem Link: https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

// Intuition
// Think Greedily.. We pick biggest pile and remove from it...

// Approach
// Using Max-Heap we can keep track of which is the largest pile...

// Complexity
// Time complexity:
// O(nlogn)

// Space complexity:
// O(n)

// Code
class Solution {
    public int minStoneSum(int[] piles, int k) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int pile : piles){
            pq.offer(pile);
        }

        for(int i = 0; i < k; i++){
            int temp = pq.poll();
            int remove = (int)Math.floor(temp/2);
            pq.offer((temp - remove));
        }

        long sum = 0;

        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        return (int)sum;
    }
}
