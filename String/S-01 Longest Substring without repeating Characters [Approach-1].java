//    LeetCode Problem Link: 3. Longest Substring without repeating characters

    /*
    Approach-1: Using a Flag variable to keep track of characters
    */
    public int lengthOfLongestSubstring(String s) {
        // we'll use flag to keep check over repeating characters
        boolean[] flag = new boolean[256];
        
        //to make life easier
        char[] arr = s.toCharArray();
        
        int start = 0; // to keep track of index from where we are starting to count
        int result = 0;
        
        for(int i=0; i<arr.length; i++){
            char current = arr[i];
            if(flag[current]){
                //update result
                // i is the end point and start as mentioned above is where we begin of counting
                result = Math.max(result, i-start);
                
                // Loop over again from start till end(i) to update flag because we are going to restart our counting
                for(int k = start; k<i; ++k){
                    if(arr[k]==current){ // if we reached to the element that has repeated so we wish to break the loop because we want it to remain false in our flag
                        start = k+1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            }else{
                flag[current]=true;
            }
        }
        result = Math.max(arr.length-start, result);
        
        return result;
    }
