// LeetCode Problem Link: https://leetcode.com/problems/reward-top-k-students/description/  

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();
        
        for(String s : positive_feedback){
            pos.add(s);
        }
        for(String s : negative_feedback){
            neg.add(s);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(report.length, new FeedBack_Compare());
        
        for(int i = 0; i < report.length; i++){
            String feedback = report[i];
            int score = 0;
            for(String curr : feedback.split(" ", 0)){
                if(pos.contains(curr)){
                    score += 3;
                }else if(neg.contains(curr)){
                    score--;
                }
            }
            pq.add(new int[]{score, student_id[i]});            
        }
        
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(!pq.isEmpty() && i < k){
            ans.add(pq.poll()[1]);
            i++;
        }
        
        return ans;
    }
    class FeedBack_Compare implements Comparator<int[]>{
        public int compare(int[] student1, int[] student2){
            int comp = student2[0] - student1[0];
            if(comp == 0){
                return student1[1] - student2[1];
            }
            return comp;
        }
    }
}
