// Problem Link: https://practice.geeksforgeeks.org/problems/lru-cache/0

class LRUCache
{
    static Node head = new Node(0, 0);
    static Node tail = new Node(0, 0);
    
    static Map<Integer, Node> map ;
    static int capacity;
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        capacity = cap;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
        return temp.value;
        }
        else{
            return -1;
        }
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }
    
    static void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
    }
    
    static void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node{
    Node next, prev;
    int key, value;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
