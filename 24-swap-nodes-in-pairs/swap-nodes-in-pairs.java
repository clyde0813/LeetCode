class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {
            ListNode p = head.next;
            head.next = swapPairs(head.next.next);
            p.next = head;
            return p;
        }        
        return head;
    }
}