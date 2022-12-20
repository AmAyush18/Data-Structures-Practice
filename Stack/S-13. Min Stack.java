// LeetCode Problem Link: https://leetcode.com/problems/min-stack/description/

class MinStack {
    Stack<Integer> st;
    int mini;
    public MinStack() {
        st = new Stack<>();
        mini = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            mini = Integer.MAX_VALUE;
        }else{
            mini = getMin();
        }
        if(val <= mini) mini = val;
        st.push(val);
        st.push(mini);
    }
    
    public void pop() {
        st.pop();
        st.pop();
    }
    
    public int top() {
        int temp = st.pop();
        int top = st.peek();
        st.push(temp);
        return top;
    }
    
    public int getMin() {
        return st.peek();
    }
}
