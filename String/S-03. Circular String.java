// LeetCode Problem Link: https://leetcode.com/problems/circular-sentence/description/

// Approach-1
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ", 0);
        int n = words.length;
        if(n == 1){
            if((int)words[0].charAt(0) == (int)words[0].charAt(words[0].length()-1)){
                return true;
            }else{
                return false;
            }
        }
        
        for(int i = 1; i < n; i++){
            int x = words[i-1].length()-1;
            if((int)words[i-1].charAt(x) != (int)words[i].charAt(0)){
                return false;
            }
        }
        if((int)words[0].charAt(0) == (int)words[n-1].charAt(words[n-1].length()-1)){
            return true;
        }
        return false;
    }
}

// Approach-2
class Solution {
    public boolean isCircularSentence(String sentence) {
        
        int count = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sentence.length(); i++){
            char ch = sentence.charAt(i);
            if(ch == ' '){
                count++;
                if(sentence.charAt(i-1) != sentence.charAt(i+1)){
                    return false;
                }
                sb = new StringBuilder();
            }else{
                sb.append(ch);
            }
        }
        if(sentence.charAt(0) == sb.toString().charAt(sb.length()-1)){
            return true;
        }       
        return false;
    }
}
