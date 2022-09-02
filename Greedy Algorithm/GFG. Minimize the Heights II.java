// Problem link: https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        
        int largest = arr[n-1] - k;
        int smallest = arr[0] + k;
        int ans = arr[n-1] - arr[0];
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n-1; i++){
            
            max = Math.max(largest, arr[i]+k);
            min = Math.min(smallest, arr[i+1]-k);
            if(min < 0)
                continue;
            
            ans = Math.min(ans, max-min);
            
        }
        return ans;
    }
}
