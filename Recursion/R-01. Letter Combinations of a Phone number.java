// LeetCode Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// GFG Problem Link: https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1

class Solution {
    List<String> ans;
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        
        ans = new ArrayList<>();

        if(digits.length() == 0) return ans;
        
        int idx = 0;  
        StringBuilder output = new StringBuilder();

        solve(digits, idx, output);
        
        return ans;
    }

    void solve(String digits, int idx, StringBuilder output){

        if(idx >= digits.length()){
            ans.add(output.toString());
            return;
        }

        // button that is being pressed
        int num = digits.charAt(idx)-'0';
        // values associated with current number
        String value = map[num];

        for(int i = 0; i < value.length(); i++){
            output.append(value.charAt(i));
            solve(digits, idx+1, output);
            output.deleteCharAt(output.length()-1);
        }

    }

}   
