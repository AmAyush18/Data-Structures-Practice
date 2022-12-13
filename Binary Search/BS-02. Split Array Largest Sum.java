// GFG Problem Link: https://practice.geeksforgeeks.org/problems/f04fd67b26b4828b6180715d8b1700426b637247/1

class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for(int ele : arr){
            low = Math.max(low, ele);
            high += ele;
        }
        
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(mid, arr, K)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    
    static boolean isPossible(int maxSum, int[] arr, int k){
        int currSum = 0;
        int count = 0;
        for(int i : arr){
            if(currSum + i > maxSum){
                count++;
                currSum = i;
            }else{
                currSum += i;
            }
        }
        return (count + 1 <= k);
    }
    
};
