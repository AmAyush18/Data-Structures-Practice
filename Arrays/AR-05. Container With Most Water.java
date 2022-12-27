// GFG Problem Link: https://practice.geeksforgeeks.org/problems/container-with-most-water0535/1

class Solve{
    
    long maxArea(int arr[], int len){
        
        int i = 0, j = len-1;
        long maxArea = 0;
        while(i < j){
            long curr = Math.min(arr[i], arr[j]) * (j-i);
            maxArea = Math.max(maxArea, curr);
            if(arr[i] < arr[j]){
                i++;
            }else if(arr[j] < arr[i]){
                j--;
            }else{
                i++;
                j--;
            }
        }
        
        return maxArea;
    }
    
}
