

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();

        permutations(0, nums);
        return ans;
    }

    private void permutations(int ind, int[] nums){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int ele : nums) ds.add(ele);

            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < nums.length; i++){
            swap(i, ind, nums);
            permutations(ind+1, nums);
            swap(i, ind, nums);
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
