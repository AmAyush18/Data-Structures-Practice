// https://leetcode.com/problems/find-the-winner-of-an-array-game

class Solution {
    public int getWinner(int[] arr, int k) {
        int winner =arr[0];
        int counter = 0;

        for(int i = 1; i< arr.length ; i++){
            if(arr[i] > winner){
                counter = 1;
                winner = arr[i];
            }else {
                counter++;
            }
            if(counter == k){
                break;
            }
        }
        return winner;
    }
}
