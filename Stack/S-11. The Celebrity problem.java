// GFG Problem Link: https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

class Solution
{ 

    int celebrity(int mx[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i = 0; i < n; i++){
    	    st.push(i);
    	}
    	
    	while(st.size() > 1){
    	    int a = st.pop();
    	    int b = st.pop();
    	    
    	    if(mx[a][b] == 1){
    	        st.push(b);
    	    }else if(mx[b][a] == 1){
    	        st.push(a);
    	    }
    	}
    	
    	// the left element in the stack is a potential candidate to be celebrity
        // 	so we check if he is celebrity or not
    
        int candidate = st.pop();
        
        for(int i = 0; i < n; i++){
            if(mx[candidate][i] == 1){
                return -1;
            }
            
            if(mx[i][candidate] == 0 && i != candidate){
                return -1;
            }
        }
        
        return candidate;
    }
}
