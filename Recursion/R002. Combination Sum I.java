// Problem Link: https://leetcode.com/problems/combination-sum/description/

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ans = new ArrayList<>();
        combinations(0, target, candidates, new ArrayList<>());
        return ans;
    }

    private void combinations(int ind, int tar, int[] candidates, List<Integer> ds){
        if(ind == candidates.length){
            if(tar == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[ind] <= tar){
            ds.add(candidates[ind]);
            combinations(ind, tar - candidates[ind], candidates, ds);
            ds.remove(ds.size() - 1);
        }
        combinations(ind+1, tar, candidates, ds);
    }
}
