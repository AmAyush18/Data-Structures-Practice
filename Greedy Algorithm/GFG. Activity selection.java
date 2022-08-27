// Problem Link: https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1

class Pair{
    int s;
    int e;
    
    Pair(int s, int e){
        this.s = s;
        this.e = e;
    }
}

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        Pair[] p = new Pair[n];
        
        for(int i = 0; i<n; i++){
            p[i] = new Pair(start[i], end[i]);
        }
        
        Arrays.sort(p, (p1,p2) -> p1.e - p2.e);
        
        int count = 1;
        int tempEnd = 0;
        
        for(int i = 1; i<n; i++){
            
            if(p[i].s > p[tempEnd].e){
                count++;
                tempEnd = i;
            }
        }
        
        return count;
    }
}
