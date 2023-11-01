// Problem Link: https://leetcode.com/problems/trapping-rain-water/submissions/1089266893/

class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];

        int k = n-2, i = 1;
        
        for(; i < n; i++, k--){
            left[i] = Math.max(left[i-1], height[i]);
            right[k] = Math.max(right[k+1], height[k]);
        }

        int maxWaterTrapped = 0;

        for(i = 0; i < n; i++){
            maxWaterTrapped += Math.min(left[i], right[i]) - height[i];
        }

        return maxWaterTrapped;
    }
}
