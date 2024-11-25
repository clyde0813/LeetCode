class Solution {
    public boolean isValid(String s) {
        if(s.length()==1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for(int i=0;i<s.length();i++){
            char s_char = s.charAt(i);
            if(s_char == '(' || s_char == '{' || s_char == '['){
                stack.push(s.charAt(i));
            }else if(stack.isEmpty() || table.get(s.charAt(i))!=stack.pop()){
                return false;
            }
        }
        return stack.size()==0;
    }
}