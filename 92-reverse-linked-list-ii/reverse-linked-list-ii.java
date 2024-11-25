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
        ListNode endRoot = end;
        ListNode rep = null;
        for(int i=0;i<right-left+1;i++){
            ListNode next = end.next;
            end.next = rep;
            rep = end;
            end = next;
        }
        endRoot.next = end;
        node.next = rep;
        return root.next;
    }
}