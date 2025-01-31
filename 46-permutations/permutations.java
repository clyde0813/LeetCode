class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(results, new LinkedList<>(), lst);
        return results;
    }

    public void dfs(List<List<Integer>> results, LinkedList<Integer> prevElements, List<Integer> elements){
        if(elements.isEmpty()){
            results.add(prevElements.stream().collect(Collectors.toList()));
        }
        for(Integer e : elements){
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);
            prevElements.add(e);
            dfs(results, prevElements, nextElements);
            prevElements.removeLast();
        }
    }
}