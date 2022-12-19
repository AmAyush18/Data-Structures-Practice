// LeetCode Problem Link: https://leetcode.com/problems/valid-parentheses/description/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i < n){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(!st.isEmpty() && isMatching(st.peek(), ch)){
                    st.pop();
                }else{
                    return false;
                }
            }
            i++;
        }

        return st.isEmpty();
    }

    boolean isMatching(char op1, char op2){
        if(op1 == '(' && op2 == ')'){
            return true;
        }
        else if(op1 == '[' && op2 == ']'){
            return true;
        }
        else if(op1 == '{' && op2 == '}'){
            return true;
        }
        return false;
    }
}
