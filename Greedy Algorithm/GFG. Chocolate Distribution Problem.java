Problem Link: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        
        long ans = Integer.MAX_VALUE;
        
        int i = 0;
        int j = m-1;
        while(j<n){
            ans = Math.min(ans, a.get(j)-a.get(i));
            i++;
            j++;
        }
        
        return ans;
    }
}
