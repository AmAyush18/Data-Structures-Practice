// GFG Problem Link: https://practice.geeksforgeeks.org/problems/asteroid-collision/1

class Solution {
    public static int[] asteroidCollision(int n, int[] asteroids) {
        // code here
        
        Stack<Integer> st = new Stack<>();
        
        for(int aster : asteroids){
            
            if(aster < 0){
                
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(aster)){
                    st.pop();
                }
                
                if(!st.isEmpty()){
                    if(st.peek() == Math.abs(aster)){
                        st.pop();
                    }else if(st.peek() < 0){
                        st.push(aster);
                    }
                }else if(st.isEmpty()){
                    st.push(aster);
                }
            }
            else{
                st.push(aster);
            }
        }
        
        if(st.isEmpty()) return new int[]{};
        
        int[] ans = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }
        
        return ans;
    }
}
