class Solution {
    int left, maxLen=0;
    public void extendPalindrome(String s, int j, int k){
        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        j++;
        k--;
        if(maxLen<k-j+1){
            left = j;
            maxLen = k-j+1;
        }
    }
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        for(int i=0;i<s.length()-1;i++){
            extendPalindrome(s, i, i+1);
            extendPalindrome(s, i, i+2);
        }
        return s.substring(left, left+maxLen);
    }
}