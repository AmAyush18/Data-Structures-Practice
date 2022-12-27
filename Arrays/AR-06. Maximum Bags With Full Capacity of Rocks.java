// LeetCode Problem Link: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = rocks.length;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= additionalRocks){
                additionalRocks -= arr[i];
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
