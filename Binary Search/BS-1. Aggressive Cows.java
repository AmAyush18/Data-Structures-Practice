// GFG Problem Link: https://practice.geeksforgeeks.org/problems/aggressive-cows/1

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        int ans = 1;
        while(low <= high){
            // for middle value
            int mid = (low+high)/2;
            if(isPossible(k, stalls, mid)){ 
                ans = Math.max(ans, mid);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    
    // Function to check if it is possible to place k cows in stalls with minimum distance of 'min'
    static boolean isPossible(int k, int[] stalls, int minDis){
        int count = 1; // No. of cows we have placed
        int prevCow = stalls[0];  // position of previous cow
        
        for(int i = 1; i < stalls.length; i++){ 
            if(stalls[i] - prevCow >= minDis){  // if our gap is greater than equal to minDis means it is possible to have tha min distance
                prevCow = stalls[i];
                count++;
            }
        }
        return count >= k;
    }
}
