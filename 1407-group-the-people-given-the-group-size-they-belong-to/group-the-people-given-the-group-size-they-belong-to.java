class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++){
            int g = groupSizes[i];
            if(groupMap.containsKey(g)){
                groupMap.get(g).add(i);
            } else {
                groupMap.put(g, new ArrayList<>(Arrays.asList(i)));
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : groupMap.entrySet()) {
            int groupSize = entry.getKey();
            List<Integer> members = entry.getValue();
            for (int i = 0; i < members.size(); i += groupSize) {
                result.add(members.subList(i, i + groupSize));
            }
        }
        return result;
    }
}