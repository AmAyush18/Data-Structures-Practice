// GFG Problem Link: https://practice.geeksforgeeks.org/problems/course-schedule/1
// LeetCode Problem Link: https://leetcode.com/problems/course-schedule/description/

class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prereq.length; i++){
            adj.get(prereq[i][1]).add(prereq[i][0]);
        }

        int indeg[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(Integer node : adj.get(i)){
                indeg[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0) 
                q.add(i);
        }

        int i = 0;  // to count number of tasks we're able to complete (no. of elements in our topo sort)
        while(!q.isEmpty()){
            Integer node = q.poll();
            i++;   

            for(Integer it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
            }
        }

        return i == numCourses;
    }
}
