class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> cMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(cMap.containsKey(c)&&left<=cMap.get(c)){
                left = cMap.get(c) + 1;
            } else {
                 maxLen = Math.max(maxLen, right - left + 1);
            }
            cMap.put(c, i);
            right++;
        }
        return maxLen;
    }
}