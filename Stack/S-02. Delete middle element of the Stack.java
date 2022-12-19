// GFG Problem Link: https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        solve(s, 0, sizeOfStack);
    } 
    
    void solve(Stack<Integer> st, int count, int sz){
        if(count == sz/2){
            st.pop();
            return;
        }
        
        int num = st.pop();
        
        //Recursive call
        solve(st, count+1, sz);
        
        // while returning push back the element that you popped 
        st.push(num);
    }
}
