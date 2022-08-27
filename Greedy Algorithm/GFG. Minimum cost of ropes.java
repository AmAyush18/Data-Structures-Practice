// Problem Link: https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(long ele : arr){
            pq.offer(ele);
        }
        
        long ans = 0;
        
        while(pq.size()>=2){
            long x = pq.poll();
            long y = pq.poll();
            
            long sum = x + y;
            
            ans += sum;
            pq.offer(sum);
        }
        
        return ans;
    }
}
