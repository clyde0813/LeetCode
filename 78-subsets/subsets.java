class Solution {
    public void dfs(List<List<Integer>> results, int[] nums, ArrayDeque<Integer> elements, int index){
        results.add(new ArrayList<>(elements));
        for(int i=index; i<nums.length; i++){
            elements.add(nums[i]);
            dfs(results, nums, elements, i+1);
            elements.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, nums, new ArrayDeque<>(), 0);
        return results;
    }
}