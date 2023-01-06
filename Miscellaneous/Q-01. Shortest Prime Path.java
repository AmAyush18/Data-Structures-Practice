// GFG Problem Link: https://practice.geeksforgeeks.org/problems/1646a9b5169d7571cf672f2a31533af083d1f479/1

class Solution
{
    boolean[] prime;
    Solution()
    {
        prime = new boolean[10000];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        
        // Marking all primes using Sieve of Eratosthenes
        for(int i = 2;i < 10000; i++){
            if(!prime[i])continue;
            for(int j = 2; i*j < 10000; j++)
                prime[i*j] = false;
        }
    }
    
    public int shortestPath(int Num1,int Num2){
        
        // Using BFS for finding shortest path
        
        // array to keep track of already visited numbers
        boolean[] vis = new boolean[10000];
        // Queue for doing our BFS
        // int[] = {number, distance from Num1}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{Num1, 0});
        vis[Num1] = true;
        
        while(!q.isEmpty()){
            int[] num = q.poll();
            
            // if current number is equal to num2
            // so we return it's distance from num1
            if(num[0] == Num2){
                return num[1];
            }
            
            // otherwise convert it's digits into character array so that it's easier to traverse
            char[] dig = Integer.toString(num[0]).toCharArray();
            
            // traverse through all it's 4-digits
            for(int i = 0; i < 4; i++){
                // now by switchin each digit with different digits
                for(char ch = '0'; ch <= '9'; ch++){
                    char prevDigit = dig[i];
                    dig[i] = ch;
                    
                    // now creating a new number after changed digit
                    int newNumber = Integer.parseInt(new String(dig));
                    // if new number is not visited and prime and of 4 digits
                    // than mark it as visited and add it in queue
                    if(!vis[newNumber] && prime[newNumber] && newNumber >= 1000){
                        vis[newNumber] = true;
                        q.add(new int[]{newNumber, num[1]+1});
                    }
                    
                    dig[i] = prevDigit;
                }
            }
        }
        
        return -1;
    }
}
