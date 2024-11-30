class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int t_length = temperatures.length;
        int[] result = new int[t_length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<t_length;i++){
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int last = stack.pop();
                result[last]=i-last;
            }
            stack.push(i);
        }
        return result;
    }
}