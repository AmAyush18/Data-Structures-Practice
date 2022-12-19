class Solution{
  void insertAtBottom(Stack<Integer> st, int num){
      solve(st, num);
  }
  void sovle(Stack<Integer> st, int num){
    if(st.isEmpty()){
      st.push(num);
      return;
    }
    int x = st.pop();
    solve(st, num);
    st.push(x);
  }
}
