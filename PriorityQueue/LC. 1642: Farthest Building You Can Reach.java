class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int n = heights.length;
        
        // Min-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();  

        for(int i=0; i<n-1; i++){
            int diff = heights[i+1]-heights[i];

            if(diff<0)  // if difference is less than zero simply proceed
                continue;
            
            else if(diff>0){
                pq.add(diff); 
                /* 
                We are filling pq till the size of ladder because in worst case also we'll use all the ladders atleast
                Now, topmost element of pq will be smallest height difference so far so if possible why not use bricks
                if we have and simply poll the smallest difference to make space for our ladder to handle bigger height differences
                */
                if(pq.size() > ladders)
                    bricks -= pq.poll();  // we use bricks for smallest height so far
                if(bricks<0)
                    return i;
            }
        }
        return heights.length - 1;
    }
}
/*
T.C: O(n) where n = heights.length
S.C: O(l) where l = ladders.length
*/
