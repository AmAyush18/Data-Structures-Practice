// GFG Problem Link: https://practice.geeksforgeeks.org/problems/alien-dictionary/1

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        List<Integer> topo = topoSort(K, adj);
        
        String ans = "";
        for(int it : topo){
            ans += (char)(it + (int)('a'));
        }
        
        return ans;
    }
    
    private List<Integer> topoSort(int k, List<List<Integer>> adj){
        
        int[] indeg = new int[k];
        for(int i = 0; i < k; i++){
            for(Integer it : adj.get(i)){
                indeg[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < k; i++){
            if(indeg[i] == 0) q.add(i);
        }
        
        List<Integer> topoSort = new ArrayList<>();
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            topoSort.add(node);
            
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }
        
        return topoSort;
    }
}
