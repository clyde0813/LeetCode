class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Map<String, List<String>> results = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for(char c : chars){
                sb.append(c);
            }
            String key = sb.toString();
            if(!results.containsKey(key)){
                results.put(key, new ArrayList<>());
            }
            results.get(key).add(s);
            sb.setLength(0);
        }
        return new ArrayList<>(results.values());
    }
}