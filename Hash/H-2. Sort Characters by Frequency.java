https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        
        ArrayList<Character> arr = new ArrayList(mp.keySet());
        Collections.sort(arr, (a, b) -> mp.get(b)-mp.get(a));
        
        StringBuilder ans = new StringBuilder();
        
        for(Character ch : arr){
            for(int i = 0; i < mp.get(ch); i++){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
