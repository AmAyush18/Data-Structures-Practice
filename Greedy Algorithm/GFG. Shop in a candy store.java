// Problem Link: https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1

class Solution{
    static ArrayList<Integer> candyStore(int candies[],int n,int k){
        
        //to find min amount
        int low = 0;
        int high = n-1;
        Arrays.sort(candies);
        int min = 0;
        while(low <= high){
            min += candies[low];
            low++;
            high = high - k;
        }
        
        
        //to find max amount
        low = 0;
        high = n-1;
        int max = 0;
        while(low <= high){
            max += candies[high];
            high--;
            low = low + k;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);
        
        return ans;
    }
}
