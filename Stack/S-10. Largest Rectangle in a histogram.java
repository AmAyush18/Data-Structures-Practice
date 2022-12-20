// LeetCode Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/description/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = nextSmaller(heights, n);
        int[] prevSmaller = prevSmaller(heights, n);

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            int length = heights[i];
            int breadth = nextSmaller[i] - prevSmaller[i] - 1;
            int area = length * breadth;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public int[] nextSmaller(int[] heights, int n){

        int[] nxtSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nxtSmaller[i] = n;
            }else{
                nxtSmaller[i] = st.peek();
            }
            st.push(i);
        }
        
        return nxtSmaller;
    }

    public int[] prevSmaller(int[] heights, int n){
        int[] prevSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                prevSmaller[i] = -1;
            }
            else{
                prevSmaller[i] = st.peek();
            }
            st.push(i);
        }

        return prevSmaller;
    }
} 
