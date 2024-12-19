class Solution {
    public void dfs(List<List<Integer>> results, LinkedList<Integer> elements, int start, int end, int count){
        if(count == 0){
            results.add(elements.stream().collect(Collectors.toList()));
            return;
        }
        for(int i=start; i<=end; i++){
            elements.add(i);
            dfs(results, elements, i + 1, end, count - 1);
            elements.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new LinkedList<>(), 1, n, k);
        return results;
    }
}