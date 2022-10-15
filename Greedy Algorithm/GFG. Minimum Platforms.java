// Problem Link:- https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1?page=2&curated[]=1&sortBy=submissions

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // Greedy Approach
        
        // We'll Simply sort both arrival and departure times
        // Because we just need to know arrival times
        Arrays.sort(arr); 
        Arrays.sort(dep);
        
        int platNeeded = 1; // Initially 1 is needed for 1st train
        int maxNeeded = 1;
        
        int i = 1, j = 0;
        
        while(i < n && j < n){
            
            if(arr[i] <= dep[j]){
                platNeeded++;
                i++;
            }
            
            else if(arr[i] > dep[j]){
                platNeeded--;
                j++;
            }
            
            if(platNeeded > maxNeeded){
                maxNeeded = platNeeded;
            }
        }
        
        return maxNeeded;
    }
    
}
