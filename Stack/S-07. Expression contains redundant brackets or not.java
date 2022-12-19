// GFG Problem Link: https://practice.geeksforgeeks.org/problems/e015cb4d3f354b035d9665e7c8a54a7aefb1901b/1

class Solution {
    public static int checkRedundancy(String s) {
        
        Stack<Character> st = new Stack<>();
        
        int i = 0;
        int n = s.length();
        
        while(i < n){
            char ch = s.charAt(i);
            if(ch == ')'){
                int count = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    char x = st.pop();
                    if(isOperator(x)) count++;
                }
                st.pop();
                if(count == 0) return 1;
            }else{
                st.push(ch);
            }
            i++;
        }
        
        return 0;
    }
    
    static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
