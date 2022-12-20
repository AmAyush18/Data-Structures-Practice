// LeetCode Problem Link: https://leetcode.com/problems/maximal-rectangle/description/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];

        int maxAns = 0;

        // moving to each row
        for(int i = 0; i < n; i++){
            // now for each column calculating height
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            int curr = areaHistogram(heights);
            maxAns = Math.max(curr, maxAns);
        }
        return maxAns;
    }

    public int areaHistogram(int[] heights){
        int n = heights.length;
        int[] ns = nextSmaller(heights, n);
        int[] ps = prevSmaller(heights, n);
        int max = 0;

        for(int i = 0; i < n; i++){
            int l = heights[i];
            int b = ns[i] - ps[i] - 1;
            int curr = l * b;
            max = Math.max(curr, max);
        }
        return max;
    }

    public int[] nextSmaller(int[] heights, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = n;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int[] prevSmaller(int[] heights, int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

}
