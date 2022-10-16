// Problem Link: 

// Brute force approach
class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int ans = 0;
        int i = 0, j = 0;
        while(i < n && j < m && k > 0){
            if(arr1[i] <= arr2[j]){
                i++;
                k--;
                if(k == 0){
                    return arr1[i-1];
                }
            }
            else{
                j++;
                k--;
                if(k == 0){
                    return arr2[j-1];
                }
            }   
        }
        while(i < n && k > 0){
            i++;
            k--;
            if(k == 0){
                return arr1[i-1];
            }
        }
        while(j < m && k > 0){
            j++;
            k--;
            if(k == 0){
                return arr2[j-1];
            }
        }
        return -1;
    }
}
