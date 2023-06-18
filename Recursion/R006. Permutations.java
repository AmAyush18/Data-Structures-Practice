// Problem Link: https://leetcode.com/problems/permutations/description/

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        
        ans = new ArrayList<>();
        permutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;        
    }

    private void permutations(int[] nums, List<Integer> ds, boolean[] vis){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(vis[i]) continue;

            vis[i] = true;
            ds.add(nums[i]);
            permutations(nums, ds, vis);
            ds.remove(ds.size()-1);
            vis[i] = false;
        }
    }
}
