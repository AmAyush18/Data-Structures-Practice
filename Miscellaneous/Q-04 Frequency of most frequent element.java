// https://leetcode.com/problems/frequency-of-the-most-frequent-element/

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0 , sum = 0 , maxFreq = 0 ;
        for(int right = 0 ; right < nums.length ; right++){
            sum += nums[right] ;
            while( (right - left +1)*nums[right] - sum > k ){
                sum -= nums[left] ;
                left++ ;
            }

            maxFreq = Math.max(maxFreq , right - left + 1) ;
        }
        return maxFreq;
    }
}
