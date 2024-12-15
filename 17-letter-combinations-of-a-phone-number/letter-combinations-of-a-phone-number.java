class Solution {
    public void dfs(List<String> results, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path){
        if(path.length()==digits.length()){
            results.add(String.valueOf(path));
            return;
        }
        for(char c : dic.get(digits.charAt(index))){
            dfs(results, dic, digits, index + 1, new StringBuilder(path).append(c));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        Map<Character, List<Character>> dic = new HashMap<>();
        if(digits.length() == 0) return results;
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a', 'b', 'c'));
        dic.put('3', List.of('d', 'e', 'f'));
        dic.put('4', List.of('g', 'h', 'i'));
        dic.put('5', List.of('j', 'k', 'l'));
        dic.put('6', List.of('m', 'n', 'o'));
        dic.put('7', List.of('p', 'q', 'r', 's'));
        dic.put('8', List.of('t', 'u', 'v'));
        dic.put('9', List.of('w', 'x', 'y', 'z'));
        dfs(results, dic, digits, 0, new StringBuilder());
        return results;
    }
}