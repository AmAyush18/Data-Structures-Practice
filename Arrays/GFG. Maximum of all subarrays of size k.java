// Sliding Window Approach

// Problem Link:- https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1?page=2&curated[]=1&sortBy=submissions

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0;
        
        // Inserting first k "USEFUL" elements in queue
        // USEFUL elements are those, to the left of which all elements are smaller than it
        for( ; i < k; i++){
            
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        
        // Processing for all other elements
        
        for(; i < n; i++){
            ans.add(arr[dq.peekFirst()]);
            
            // Remove thos elements which are out of scope for this window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            
            // Removing elements those are not USEFUL
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            
            dq.offerLast(i);
        }
        
        ans.add(arr[dq.peekFirst()]);
        
        return ans;
    }
}
