// GFG PROBLEM LINK: https://practice.geeksforgeeks.org/problems/3-divisors3942/1

class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = 0;
        for(Long ele : query){
            n = Math.max(n, (int)Math.sqrt(ele));
        }
        
        boolean[] prime = new boolean[n+1];
        
        Arrays.fill(prime, true);
        for(int i = 2; i <= n; i++){
            if(prime[i]){
                for(int j = i*i; j <= n; j+= i){
                    prime[j] = false;
                }
            }
        }
        
        int[] dp = new int[n+1];  // We'll store count of prime numbers
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1];
            if(prime[i]) {
                dp[i]++;
            }
        }
        
        for(Long it : query){
            int x = (int)Math.sqrt(it);
            ans.add(dp[x]);
        }
    return ans;
    }
    
}
