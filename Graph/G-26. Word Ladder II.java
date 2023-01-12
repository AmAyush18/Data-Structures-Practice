// GFG Problem Link: https://practice.geeksforgeeks.org/problems/word-ladder-ii/1
// LeetCode Problem Link: https://leetcode.com/problems/word-ladder-ii/description/

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>();
        for(String word : wordList) set.add(word);
        
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        
        q.add(ls);
        // list of words used at current level
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            ArrayList<String> curr = q.poll();
            // erase all words that has been used in the previous level
            if(curr.size() > level){
                level++;
                for(String str : usedOnLevel){
                    set.remove(str);
                }
            }
            
            // fetch the last word from current list
            String word = curr.get(curr.size() - 1);
            if(word.equals(targetWord)){
                // if it's the first list we have found simply add
                if(ans.size() == 0) ans.add(curr);
                // otherwise check if it matches the length of our previous list
                else if(ans.get(0).size() == curr.size()) ans.add(curr);
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        curr.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(curr);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        curr.remove(curr.size() - 1);
                    }
                }
            }
        }
        
        return ans;
    }
}
