// LeetCode Problem Link : https://leetcode.com/problems/delete-columns-to-make-sorted/description/

class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int[] col = new int[strs[0].length()];

        for(String curr : strs){
            for(int i = 0; i < curr.length(); i++){
                int val = (int)(curr.charAt(i) - 'a');
                if(col[i] != -1 && col[i] > val){
                    col[i] = -1;
                    count++;
                }else if(col[i] != -1){
                    col[i] = val;
                }

//                 System.out.print(col[i] + "\t");
            }
//             System.out.println();
        }
        
        return count;
    }
}
