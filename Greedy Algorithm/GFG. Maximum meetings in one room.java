// Problem Link: https://practice.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1

class Pair{
    int s;
    int e;
    int ind;
    
    Pair(int start, int end, int ind){
        this.s = start;
        this.e = end;
        this.ind = ind;
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        
        Pair[] p = new Pair[n];
        for(int i = 0; i<n; i++){
            p[i] = new Pair(start[i], end[i], i);
        }
        
        Arrays.sort(p, (a,b) -> a.e - b.e);
        
        int tempEnd = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(p[0].ind+1);
        
        for(int i = 1; i<n; i++){
            if(p[i].s > p[tempEnd].e){
                ans.add(p[i].ind+1);
                tempEnd = i;
            }
        }
        Collections.sort(ans);
        return ans;
        
    }
}
