class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        Set<Character> freqs = new HashSet<>();
        for(char c : jewels.toCharArray()){
            freqs.add(c);
        }
        for(char c : stones.toCharArray()){
            if(freqs.contains(c)) result++;
        }
        return result;
    }
}