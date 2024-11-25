class Solution {
    public boolean isValid(String s) {
        if(s.length()==1) return false;
        char s_char;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for(int i=0;i<s.length();i++){
            s_char = s.charAt(i);
            if(s_char == '(' || s_char == '{' || s_char == '['){
                stack.push(s_char);
            }else if(stack.isEmpty() || table.get(s_char)!=stack.pop()){
                return false;
            }
        }
        return stack.size()==0;
    }
}