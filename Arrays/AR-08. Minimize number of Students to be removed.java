// GFG problem link: https://practice.geeksforgeeks.org/problems/7d0fa4007b8eabadc404fcc9fa917aa52982aa96/1

class Solution {
    public int removeStudents(int[] H, int N) {
        // list to store Longest increasing subsequence
        ArrayList<Integer> al = new ArrayList<>();
        
        // traverse through list
        for(int height : H){
            // if list is empty OR last height of list is smaller than current height
            // we simply add the current height at the end
            if(al.size() == 0 || al.get(al.size()-1) < height){
                al.add(height);
            }
            // else is last height is greater than current height
            // we find the position of perfect positon for current height
            // using binary search approach
            else if(al.get(al.size()-1) > height){
                // binary search function returns just next index if it finds this height
                // else it returns -(required index - 1)
                int pos = Collections.binarySearch(al, height);
                if(pos < 0){
                    pos = (pos * -1) - 1;
                }
                // we set current height to that index
                al.set(pos, height);
            }
        }
        
        // elements deleted = total elements - size of L.I.S
        return N - al.size();
    }
};
