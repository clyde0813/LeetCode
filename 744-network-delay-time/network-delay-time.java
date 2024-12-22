import java.util.AbstractMap;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] time : times){
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        Map<Integer, Integer> dist = new HashMap<>();
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> cur = pq.poll();
            int destination = cur.getKey();
            int destinationDist = cur.getValue();
            if(!dist.containsKey(destination)){
                dist.put(destination, destinationDist);
                if(graph.containsKey(destination)){
                    for(Map.Entry<Integer, Integer> des : graph.get(destination).entrySet()){
                        int desDist = destinationDist + des.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(des.getKey(), desDist));
                    }
                }
            }
        }
        if(dist.size() == n){
            return Collections.max(dist.values());
        }
        return -1;
    }
}