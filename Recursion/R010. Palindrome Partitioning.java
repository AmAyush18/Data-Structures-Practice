// Problem Link: https://leetcode.com/problems/palindrome-partitioning/description/

class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        solve(0, s, new ArrayList<>());
        return ans;
    }

    private void solve(int ind, String s, List<String> path){
        if(ind == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s, ind, i)){
                path.add(s.substring(ind, i+1));
                solve(i+1, s, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int st, int en){
        while(st <= en){
            if(s.charAt(st++) != s.charAt(en--))
                return false;
        }
        return true;
    }

}
