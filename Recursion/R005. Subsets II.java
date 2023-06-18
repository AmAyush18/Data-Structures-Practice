// Problem Link: https://leetcode.com/problems/subsets-ii/description/

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0, nums, new ArrayList<>());
        return ans;
    }

    private void subsets(int ind, int[] nums, List<Integer> ds){
        ans.add(new ArrayList<>(ds));

        for(int i = ind; i < nums.length; i++){
            if(i != ind && nums[i] == nums[i-1]) continue;
            
            ds.add(nums[i]);
            subsets(i+1, nums, ds);
            ds.remove(ds.size()-1);
        }
    }
}
