// Probelm Link: https://leetcode.com/problems/combination-sum-ii/description/

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0, target, candidates, new ArrayList<>());
        return ans;
    }

    private void combinations(int ind, int tar, int[] arr, List<Integer> ds){
        if(tar == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > tar) break;

            ds.add(arr[i]);
            combinations(i+1, tar-arr[i], arr, ds);
            ds.remove(ds.size()-1);
        }
    }
}
