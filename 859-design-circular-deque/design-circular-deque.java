class MyCircularDeque {
    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int val;
        public DoublyLinkedList(int val) { this.val = val; }
    }
    int len;
    int k;
    DoublyLinkedList head;
    DoublyLinkedList tail;
    public MyCircularDeque(int k) {
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.right = tail;
        tail.left = head;
        this.k = k;
        this.len = 0;
    }
    public boolean insertFront(int value) {
        if(isFull()) return false;
        DoublyLinkedList tmp = new DoublyLinkedList(value);
        tmp.right = head.right;
        tmp.left = head;
        head.right.left = tmp;
        head.right = tmp;
        len++;
        return true;
    }
    public boolean insertLast(int value) {
        if(isFull()) return false;
        DoublyLinkedList tmp = new DoublyLinkedList(value);
        tmp.right = tail;
        tmp.left = tail.left;
        tail.left.right = tmp;
        tail.left = tmp;
        len++;
        return true;
    }
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head.right.right.left = head;
        head.right = head.right.right;
        len--;
        return true;
    }
    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail.left.left.right = tail;
        tail.left = tail.left.left;
        len--;
        return true;
    }
    public int getFront() { return isEmpty() ? -1 : head.right.val; }
    public int getRear() { return isEmpty() ? -1 : tail.left.val; }
    public boolean isEmpty() { return len==0; }
    public boolean isFull() { return len==k; }
}