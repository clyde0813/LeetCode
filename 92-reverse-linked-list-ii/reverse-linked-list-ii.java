class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null) return head;
        ListNode node = new ListNode(0);
        ListNode root = node;
        node.next = head;
        for(int i=0;i<left-1;i++){
            node = node.next;
        }
        ListNode end = node.next;
        for(int i=0;i<right-left;i++){
            ListNode tmp = node.next;
            node.next = end.next;
            end.next = end.next.next;
            node.next.next = tmp;
        }
        return root.next;
    }
}