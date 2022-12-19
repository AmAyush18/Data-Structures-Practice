// LeetCode Problem Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> st = new Stack<>();
        int i = 0;
        int n = s.length();
        int count = 0;
        while(i < n){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else count++;
            }else{
                st.push(ch);
            }
            i++;
        }

        while(!st.isEmpty()){
            count++;
            st.pop();
        }
        return count;
    }
}
