class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1) return true;
        int start = 0;
        int end = s.length()-1;
        char start_c, end_c;

        while(start<end){
            start_c = s.charAt(start);
            end_c = s.charAt(end);
            if(!Character.isLetterOrDigit(start_c)){
                start++;
                continue;
            }else if(!Character.isLetterOrDigit(end_c)){
                end--;
                continue;
            }
            if(Character.toLowerCase(start_c)!=Character.toLowerCase(end_c)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}