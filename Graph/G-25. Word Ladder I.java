// LeetCode Problem Link: https://leetcode.com/problems/word-ladder/description/

class Pair{
    String first;
    int second;
    public Pair(String _first, int _second){
        first = _first;
        second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for(String word : wordList){
            set.add(word);
        }

        set.remove(beginWord);
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.first;
            int steps = curr.second;

            if(word.equals(endWord)){
                return steps;
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedChars = word.toCharArray();
                    replacedChars[i] = ch;
                    String replacedWord = new String(replacedChars);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}
