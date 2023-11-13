class Solution {
    public String sortVowels(String s) {
        
        char[]arr = s.toCharArray();
        List<Character> vowelList = new ArrayList();

        for(int i=0;i<arr.length;i++){

            char ch = arr[i];
            char chSmall = Character.toLowerCase(ch);

            if(chSmall=='a' || chSmall=='e' || chSmall=='i' || chSmall=='o' || chSmall=='u'){
                vowelList.add(arr[i]);
                arr[i] = '0';
            }
        }

        Collections.sort(vowelList);
        int j=0;

        for(int i=0;i<arr.length;i++){

            if(arr[i] == '0'){
                arr[i] = vowelList.get(j);
                j++;
            }
        }

        return new String(arr);
    }
}
