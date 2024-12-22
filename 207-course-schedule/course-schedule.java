class Solution {
    public boolean dfs(Map<Integer, List<Integer>> courseToMap, Integer start, List<Integer> takes, List<Integer> taken){
        if(takes.contains(start)) return false;
        if(taken.contains(start)) return true;
        if(courseToMap.containsKey(start)){
            takes.add(start);
            for(Integer course : courseToMap.get(start)){
                if(!dfs(courseToMap, course, takes, taken)) return false;
            }
            takes.remove(start);
            taken.add(start);
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseToMap = new HashMap<>();
        List<Integer> taken = new ArrayList<>();
        for(int[] pre : prerequisites){
            courseToMap.putIfAbsent(pre[0], new ArrayList<>());
            courseToMap.get(pre[0]).add(pre[1]);
        }
        for(Integer i : courseToMap.keySet()){
            if(!dfs(courseToMap, i, new ArrayList<>(), taken)) return false;
        }
        return true;
    }
}