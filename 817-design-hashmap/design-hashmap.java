class MyHashMap {
    static class Node{
        int key, val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    final Node[] nodes = new Node[1000000];
    final int nodes_length = 1000000;

    public int getIndex(int key){
        return key % nodes_length;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        // If node doesn't exist
        if(nodes[index] == null){
            nodes[index] = new Node(key, value);
            return;
        }
        //If node exits
        Node node = nodes[index];
        while(node != null){
            if(node.key==key){
                node.val = value;
                return;
            }
            if(node.next==null) break;
            node = node.next;
        }
        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = getIndex(key);
        if(nodes[index] == null) return -1;
        Node node = nodes[index];
        while(node != null){
            if(node.key == key){
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        if(nodes[index] == null) return;
        Node node = nodes[index];
        if(node.key == key){
            if(node.next==null){
                nodes[index] = null;
            } else {
                nodes[index] = node.next;
            }
        }
        Node prev = node;
        while(node != null){
            if(node.key == key){
                prev.next = node.next;
                return;
            } 
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */