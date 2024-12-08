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
        for(int key : groupMap.keySet()){
            int cnt = 0;
            List<Integer> tmp_list = new ArrayList<>();
            for(int val : groupMap.get(key)){
                cnt++;
                tmp_list.add(val);
                if(cnt==key){
                    result.add(tmp_list);
                    cnt = 0;
                    tmp_list = new ArrayList<>();
                }
            }
        }
        return result;
    }
}