//Problem Link: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?page=1&category[]=Hash&curated[]=1&sortBy=submissions

class GfG
{
    int maxLen(int arr[], int n)
    {   
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,-1);
        
        int maxLen = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            
            sum += arr[i];
            if(mp.containsKey(sum)){
                int len = i - mp.get(sum);
                maxLen = Math.max(len, maxLen);
            }
            else{
                mp.put(sum, i);
            }
        }
        return maxLen;
    }
}
