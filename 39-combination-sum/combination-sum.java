class Solution {
    public void dfs(List<List<Integer>> results, int[] candidates, Deque<Integer> elements, int target, int index, int cLength){
        if(target < 0) return;
        if(target == 0){
            results.add(new ArrayList<>(elements));
            return;
        }
        for(int i=index; i<cLength; i++){
            elements.add(candidates[i]);
            dfs(results, candidates, elements, target - candidates[i], i, cLength);
            elements.removeLast();
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int cLength = candidates.length;
        dfs(results, candidates, new ArrayDeque<>(), target, 0, cLength);
        return results;
    }
}