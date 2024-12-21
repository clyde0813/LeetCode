class Solution {
    public void dfs(List<List<Integer>> results, int[] candidates, Deque<Integer> elements, int target, int index){
        if(target < 0) return;
        if(target == 0){
            results.add(new ArrayList<>(elements));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            elements.add(candidates[i]);
            dfs(results, candidates, elements, target - candidates[i], i);
            elements.removeLast();
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, candidates, new ArrayDeque<>(), target, 0);
        return results;
    }
}