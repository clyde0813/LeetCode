class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) counter.put(c, counter.get(c) == null ? 1 : counter.get(c)+1);
        for(char c : s.toCharArray()){
            counter.put(c, counter.get(c)-1);
            if(seen.get(c)!=null&&seen.get(c)==true) continue;
            while(!stack.isEmpty()&&stack.peek()>c&&counter.get(stack.peek())>0) seen.put(stack.pop(), false);
            System.out.println("push : " + c);
            stack.push(c);
            seen.put(c, true);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return new String(sb);
    }
}