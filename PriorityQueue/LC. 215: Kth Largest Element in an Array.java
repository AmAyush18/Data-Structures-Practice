class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Using PriorityQueue to store element in a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        // First Insert k elements in our PriorityQueue
        for(; i<k; i++){ 
            pq.add(nums[i]);
        }
        // so the kth greatest element will always be root of our pq
        
        //Now we traverse over elements left in the array
        for(; i<nums.length; i++){
            // if our root of min heap is smaller than or equal to current element than we simply replace it with our new element
            // And priorityQueue will manage it's right position in min heap
            if(pq.peek() <= nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        
        return pq.peek();
    }
}
