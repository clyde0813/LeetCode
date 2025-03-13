class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) pq.add(n);
        for(int i = 0; i < k - 1; i++) pq.poll();
        return pq.poll();
    }
}