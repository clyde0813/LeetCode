class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        Set<Character> freq = new HashSet<>();
        for(char j : jewels.toCharArray()){
            freq.add(j);
        }
        for(char s : stones.toCharArray()){
            if(freq.contains(s)) cnt++;
        }
        return cnt;
    }
}