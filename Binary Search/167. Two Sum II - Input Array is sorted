class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        //Generalized solution so that it can handle edge cases
        if(numbers == null || numbers.length == 0){
            return null;
        }
        
        int i = 0;
        int j = numbers.length-1;
        
        // Using Binary Search Approach using two pointers
        while(i<=j){
            int x = numbers[i]+numbers[j];
            
            if(x<target)
                i++;
            
            else if(x>target)
                j--;
            
            else
                return new int[] {i+1,j+1};
        }
        return null;
    }
}

/*
T.C: O(log N)
S.C: O(1)
*/
