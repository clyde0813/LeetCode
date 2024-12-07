class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode root = new ListNode(0);
        ListNode tail = root;
        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }
        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            if(tail.next != null) pq.add(tail.next);
        }
        return root.next;
    }
}