// Problem Link: https://practice.geeksforgeeks.org/problems/minimum-swaps/1?page=2&curated[]=1&sortBy=submissions

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    class Pair{
        int ele;
        int idx;
        
        Pair(int ele, int idx){
            this.ele = ele;
            this.idx = idx;
        }
    }
    
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        Pair[] cur = new Pair[n];
        
        Pair[] des = new Pair[n];
        for(int i = 0; i < n; i++){
            des[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(des, (a, b) -> a.ele - b.ele);
        
        int count = 0;
        
        for(int i = 0; i < n;  i++){
            
            if(des[i].idx == i){
               continue;  
            } 
            else{
                count++;
                swap(des, i, des[i].idx);
                i--;
            }
        }
        
        return count;
    }
    
    void swap(Pair[] arr, int i, int j){
        Pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
