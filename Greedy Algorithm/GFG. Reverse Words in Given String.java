//  Problem Link: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String str)
    {
        StringBuilder ans  = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i = str.length()-1; i >= 0; i--){
            
            if(str.charAt(i) == '.'){
                temp.reverse();
                ans.append(temp);
                ans.append(".");
                temp = new StringBuilder();
            }
            else{
                temp.append(str.charAt(i));
            }
        }
        //For first word
        temp.reverse();
        ans.append(temp);
        
        return ans.toString();
    }
}
