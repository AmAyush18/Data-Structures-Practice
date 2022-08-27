// Problem Link: https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

class sortByProfit implements Comparator<Job>{
    
    public int compare(Job j1, Job j2){
        return j2.profit - j1.profit;
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        
        Arrays.sort(arr, new sortByProfit());
        
        int maxDeadline = 0;
        for(Job j : arr){
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        
        int[] schedule = new int[maxDeadline+1];
        Arrays.fill(schedule, -1);
        
        int maxProfit = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            
            int curProfit = arr[i].profit;
            int curJobID = arr[i].id;
            int curDead = arr[i].deadline;
            
            for(int k = curDead; k>0; k--){
                if(schedule[k] == -1){
                    maxProfit += curProfit;
                    schedule[k] = curJobID;
                    count++;
                    break;
                }
            }
        }
        
        int[] ans = new int[]{count, maxProfit};
        
        return ans;
        
    }
}
