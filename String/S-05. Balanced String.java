// GFG Problem Link: https://practice.geeksforgeeks.org/problems/balanced-string1627/1

class Solution {
    
    static String BalancedString(int N) {
     int temp=N;
     String lett="abcdefghijklmnopqrstuvwxyz";
     StringBuilder sb=new StringBuilder("");

     while(N>26)
     {
         sb.append(lett);
         N-=26;
     }

     if((temp&1)==0)
     {
         makeString(sb,N/2,false);
         makeString(sb,N/2,true); //printing reverse
     }
     else
     {
         int sum=sumOfDigits(temp);
         if((sum&1)==0)
         {
             makeString(sb,(N+1)/2,false);
             makeString(sb,(N-1)/2,true);
         }
         else
         {
             makeString(sb,(N-1)/2,false);
             makeString(sb,(N+1)/2,true);
         }
     }
     return sb.toString();
    }

    public static int sumOfDigits(int n)
    {
        int sum=0;

        while(n>0)
        {
            int rem=n%10;
            sum+=rem;
            n=n/10;
        }
        return sum;
    }

    public static void makeString(StringBuilder sb,int n,boolean reverse)
    {
        int asci=0;
    
        if(!reverse)
        asci=0;
        else
        asci=26-n;

        while(n>0)
        {
            char ch=(char)((asci%26)+97);
            sb.append(ch);
            asci++;
            n--;
        }
    }
}
