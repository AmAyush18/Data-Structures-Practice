// Problem Link:- https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1?page=2&curated[]=1&sortBy=submissions

class Solution
{
    public int[][] overlappedInterval(int[][] inter)
    {
        List<int[]> ans = new ArrayList<>();
        
        if(inter.length == 0 || inter == null)
            return ans.toArray(new int[0][]);
        
        Arrays.sort(inter, (a, b) -> a[0] - b[0]);
        
        int start = inter[0][0];
        int end = inter[0][1];
        
        for(int[] ele : inter){
            if(ele[0] <= end){
                end = Math.max(end, ele[1]);
            }
            else{
                ans.add(new int[]{start, end});
                start = ele[0];
                end = ele[1];
            }
        }
        
        ans.add(new int[]{start, end});
    
        return ans.toArray(new int[0][]);
    }
}
