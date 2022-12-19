// GFG Problem Link: https://practice.geeksforgeeks.org/problems/reverse-a-stack/1

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()){
            return;
        }
        int num = s.pop();
        reverse(s);
        insertAtBottom(s, num);
    }
    
    static void insertAtBottom(Stack<Integer> st, int num){
        if(st.isEmpty()){
            st.push(num);
            return;
        }
        int x = st.pop();
        insertAtBottom(st, num);
        st.push(x);
    }
}
