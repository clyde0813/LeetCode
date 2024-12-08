class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tail = new ListNode(0);
        ListNode root = tail;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for(ListNode node : lists){
            if(node!=null) pq.add(node);
        }
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            if(tail.next!=null){
                pq.add(tail.next);
            }
        }
        return root.next;
    }
}