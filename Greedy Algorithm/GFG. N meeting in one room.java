// Problem Link: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class pair{
    int start;
    int end;
    
    pair(int s, int e){
        this.start = s;
        this.end = e;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        int tempEnd = 0;
        int count = 1;
        pair[] arr = new pair[n];
        for(int i = 0; i<n; i++){
            arr[i] = new pair(start[i], end[i]);
        }
        
        Arrays.sort(arr, (a, b)-> a.end - b.end);
        
        for(int i = 1; i<n; i++){
            if(arr[i].start > arr[tempEnd].end){
                tempEnd = i;
                count++;
            }
        }

        return count;
        
    }
}
