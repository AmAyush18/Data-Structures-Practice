// GFG Problem link: https://practice.geeksforgeeks.org/problems/a-difference-of-values-and-indexes0302/1

/* 
 Algorithm: 
..> (i - j) will always be negative as i is always less than j
..> So we open |i - j| as -(i - j);
..> |arr[i] - arr[j]| could be two things -> (arr[i] - arr[j]) or -(arr[i] - arr[j])
..> So considering both cases we can write it as:-
..> Case 1, (arr[i] > arr[j]) : (arr[i] - i) - (arr[j] - j) 
..> Case 2, (arr[i] < arr[j]) : (arr[j] - j) - (arr[i] - i) 
..> Taking it as A - B we gotta maximise A and minimise B
*/

class Solution{
   
    public static int maxDistance (int arr[], int n) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            
            min1 = Math.min(min1, arr[i] + i);
            min2 = Math.min(min2, -arr[i] + i);
            max1 = Math.max(max1, arr[i] + i);
            max2 = Math.max(max2, -arr[i] + i);
            
        }
        
        int res1 = max1 - min1;
        int res2 = max2 - min2;
        
        return Math.max(res1, res2);
    }
}
