package LC;

import java.util.HashMap;
import java.util.Map;

public class LC0146_LRU_CacheDoublyLL {
    private Map<Integer, DoublyListNode> map;
    private DoublyListNode head;
    private DoublyListNode tail;
    private int size;
    private final int capacity;

    class DoublyListNode{
        DoublyListNode prev;
        DoublyListNode next;
        int key;
        int value;
        public DoublyListNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    public LC0146_LRU_CacheDoublyLL(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoublyListNode(0,0);
        tail = new DoublyListNode(0,0);
        head.next = tail;
        ///head.prev = head;
        tail.prev = head;
        //tail.next = tail;
    }
    public int get(int key){
        if (map.containsKey(key)) {
            DoublyListNode target = map.get(key);

            removeNode(target);
            addToTail(target);

            return target.value;
        }
        return -1;
    }
    public void put(int key, int value){
        if (map.containsKey(key)) {
            DoublyListNode changeValueNode = map.get(key);
            changeValueNode.value = value;

            removeNode(changeValueNode);
            addToTail(changeValueNode);
        } else {
            DoublyListNode insertNode = new DoublyListNode(key, value);
            if (size >= capacity) {
                DoublyListNode removedNode = head.next;
                removeNode(removedNode);
                map.remove(removedNode.key);
            }
            addToTail(insertNode);
            map.put(key, insertNode);
        }
    }
    private void addToTail(DoublyListNode newTail) {
        newTail.prev = tail.prev;//head <- n
        tail.prev.next = newTail;//head -> n

        tail.prev = newTail;    //n <- tail
        newTail.next = tail;    //n -> tail
        size++;
    }
    private void removeNode(DoublyListNode removeNode) {
        DoublyListNode prevNode = removeNode.prev; //head
        DoublyListNode nextNode = removeNode.next; //tail

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
    public static void main(String[] args) {
        LC0146_LRU_CacheDoublyLL cache = new LC0146_LRU_CacheDoublyLL( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(3, 2);
        cache.get(3);
        cache.get(2);
        cache.put(4,3);
        cache.get(2);
        cache.get(3);
        cache.get(4);

    }
}
