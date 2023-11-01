// Problem Link: https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        // Moor's Voting Algorithm

        int maxElementIndex = 0;
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[maxElementIndex]) count++;
            else count--;
            if(count == 0){
                maxElementIndex = i;
                count = 1;
            }
        }

        // since it's given than majority element is always present
        // hence our majorityElementIndex is the answer
        // otherwise it was potential answer and we need to confirm by iterating
        
        return nums[maxElementIndex];
    }
}
