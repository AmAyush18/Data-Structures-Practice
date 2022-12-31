// GFG Problem Link: https://practice.geeksforgeeks.org/problems/af49b143a4ead583e943ca6176fbd7ea55b121ae/1

class Solution {
    
    public int minLaptops(int N, int[] start, int[] end) {
        
        // to store max lapi needed
        int maxLapi = 1;
        
        // to keep track of current count of laptops in use
        int currCountLapi = 1;
        
        // it's obvious that no process can end before starting 
        // so we sort both starting and ending times
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 1;
        int j = 0;
        
        while(i < N && j < N){
            // if no process is ending before the starting of current
            // we need one more laptop to execute this current process
            if(start[i] < end[j]){
                currCountLapi++;
                i++;
            }
            // if any process is ending before or at start of this current process 
            // this we means one laptop is getting idle
            else if(start[i] >= end[j]){
                currCountLapi--;
                j++;
            }
            
            // if current count of laptops in use is greater than maxLaptops count
            // we update maxCount with currentCount
            if(currCountLapi > maxLapi){
                maxLapi = currCountLapi;
            }
        }
        
        // return minimum number of laptops needed to complete all process
        return maxLapi;
    }
}
