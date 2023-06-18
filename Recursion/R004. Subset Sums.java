// Problem Link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1

class Solution{
    ArrayList<Integer> ans;
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        ans = new ArrayList<>();
        
        subsets(0, 0, arr);
        return ans;
    }
    
    private void subsets(int ind, int sum, ArrayList<Integer> arr){
        if(ind == arr.size()){
            ans.add(sum);
            return;
        }
        
        subsets(ind+1, sum+arr.get(ind), arr);
        subsets(ind+1, sum, arr);
    }
}
