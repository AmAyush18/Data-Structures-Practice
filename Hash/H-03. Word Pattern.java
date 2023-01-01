// LeetCode Problem Link: https://leetcode.com/problems/word-pattern/description/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        // create map to keep track of pattern
        HashMap<Character, String> mp = new HashMap<>();
        // store each word in an array
        String[] words = s.split(" ");

        // if number of elements in pattern is not equal to number of words 
        // than no way match is possible anyways, so return false
        if(words.length != pattern.length()) 
            return false;

        // traverse all the words and validate it with the help of map
        for(int i = 0; i < words.length; i++){
            char ch = pattern.charAt(i);
            String currentWord = words[i];
            // if map doesn't contains particular key 
            if(!mp.containsKey(ch)){
                // if current word is mapped to some other key
                if(mp.containsValue(currentWord)){
                    return false;
                }
                // otherwise map current key and current word
                mp.put(ch, words[i]);
            }
            // if current key is present in the map
            else{
                String mappedWord = mp.get(ch);
                // check whether current word is equal to the previously mapped word
                if(!mappedWord.equals(currentWord)){
                    return false;
                }
            }
        }

        return true;
    }
}
