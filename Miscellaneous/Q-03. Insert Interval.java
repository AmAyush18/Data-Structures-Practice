// LeetCode Problem Link: https://leetcode.com/problems/insert-interval/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // List to store intervals
        List<int[]> li = new ArrayList<>();
        // initially we start by adding new interval into the list
        li.add(newInterval);
        //traverse through intervals
        for(int[] interval : intervals){
            int lastIdx = li.size()-1;  // index of last element
            int[] lastInterval = li.get(lastIdx);

            int currStart = interval[0];
            int currEnd = interval[1];
            int lastStart = lastInterval[0];
            int lastEnd = lastInterval[1];
            
            // means current should be before last element
            if(lastStart > currEnd){
                li.remove(lastIdx);
                li.add(interval);
                li.add(lastInterval);
            }
            // means last element is at it's right place
            // so simply add new interval
            else if(currStart > lastEnd){
                li.add(interval);
            }
            // else there's is need to merge
            else{
                li.remove(lastIdx);
                interval[0] = Math.min(currStart, lastStart);
                interval[1] = Math.max(currEnd, lastEnd);
                li.add(interval);
            }
        }

        int[][] ans = new int[li.size()][2];
        int i = 0;
        for(int[] l : li){
            ans[i++] = l;
        }
        return ans;
    }
}
