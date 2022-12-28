// GFG Problem Link: https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1

class Solution {
    public boolean isPossible(int N, int[][] prereq)
    {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prereq.length; i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }
        
        int[] indeg = new int[N];
        
        for(int i = 0; i < N; i++){
            for(Integer node : adj.get(i)){
                indeg[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            if(indeg[i] == 0) q.add(i);
        }
        
//         List<Integer> topo = new ArrayList<>();  we don't need to store topo sort list instead we can just count number of tasks being completed
        int i = 0;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
//             topo.add(node);
            i++;
            
            for(Integer it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }
        
//         return topo.size() == N;
        return i == N;
    }
    
}
