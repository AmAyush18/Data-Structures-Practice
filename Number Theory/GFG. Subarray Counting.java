
// Problem Link: https://practice.geeksforgeeks.org/contest/job-a-thon-12-hiring-challenge/problems/#

class Solution {
    public static long solve(int n, int[] A) {
        
        int count = 0;
        
        for(int i = 0; i<n; i++) {
            
            Set<Integer> st = new HashSet<>();
            
            int gcd = 0;
            
            for(int j = i; j<n; j++){
                
                gcd = findGCD(A[j], gcd);
                if(st.contains(gcd)){
                    break;
                }
                st.add(gcd);
                count++;
            }
        }
        return count;
    }
    
    static int findGCD(int a, int b){
        
        if(b == 0)
            return a;
            
        return findGCD(b, a%b);
        
    }
}
