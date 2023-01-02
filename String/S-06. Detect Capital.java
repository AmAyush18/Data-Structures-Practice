// LeetCode Problem Link: https://leetcode.com/problems/detect-capital/description/

class Solution {
    public boolean detectCapitalUse(String word) {
        int cap = 0;   // to store count of uppercase letters
        int low = 0;   // to store count of lowercase letters

        // Traverse through to word to count uppercase and lowercase chars
        for(int i = 0; i < word.length(); i++){
            // pick the current letter
            char curr = word.charAt(i);
            // if it is uppercase
            if(Character.isUpperCase(curr)) cap++;
            // else if it is lowercase 
            else if(Character.isLowerCase(curr)) low++;
        }

        // We return true when,
        // all characters are capital i.e., cap = word.length()
        // OR all characters are lowercase i.e., low = word.length()
        // OR only first character is capital i.e., cap == 1 && word[0] isUpperCase

        if(cap == word.length() 
            || low == word.length()
            || (cap == 1 && Character.isUpperCase(word.charAt(0)))
        ){
            return true;
        }
        // otherwise return false
        return false;
    }
}
