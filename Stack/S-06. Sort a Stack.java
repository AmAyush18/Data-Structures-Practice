// GFG Problem Link: https://practice.geeksforgeeks.org/problems/sort-a-stack/1

class GfG{
	public Stack<Integer> sort(Stack<Integer> st)
	{
		if(st.isEmpty()){
		    return st;
		}
		
		int num = st.pop();
		
		sort(st);
		
		sortedInsert(st, num);
		return st;
	}
	
	void sortedInsert(Stack<Integer> st, int num){
	    if(st.isEmpty()){
	        st.push(num);
	        return;
	    }
	    if(st.peek() <= num){
	        st.push(num);
	        return;
	    }
	    
	    int x = st.pop();
	    
	    sortedInsert(st, num);
	    st.push(x);
	}
}
