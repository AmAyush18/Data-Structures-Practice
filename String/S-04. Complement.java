// GFG Problem Link: https://practice.geeksforgeeks.org/problems/complement3911/1

// Using Kadane's algorithm
class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        int count = 0;
        int l = -1;
        int r = -1;
        int max = 0;
        int ansLeft = -1;
        int ansRight = -1;
        
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '0'){
                count++;
            }else{
                count--;
                if(count < 0){
                    count = 0;
                    l = -1;
                }
            }
            if(count == 1 && l == -1){
                l = i;
            }
            if(count > max){
                max = count;
                ansLeft = l;
                ansRight = i;
            }
        }
        
        Vector<Integer> ans = new Vector<>();
        if(ansLeft == -1){
            ans.add(-1);
        }else{
            ans.add(ansLeft + 1);
            ans.add(ansRight + 1);
        }
        return ans;
    }
}
