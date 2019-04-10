package LC;

import java.util.*;


public class LC0146_LRU_CacheDeque {
    private Deque<ElementLRU> deque;
    private Map<Integer, ElementLRU> map;
    private final int capacity;
    class ElementLRU{
        int key;
        int value;
        ElementLRU(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public LC0146_LRU_CacheDeque(int capacity) {
        deque = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ElementLRU target = map.get(key);
            deque.remove(target);
            deque.offerLast(target);
            System.out.println(target.value);
            return target.value;
        }
        System.out.println(-1);
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ElementLRU target = map.get(key);
            target.value = value;
            deque.remove(target);
            deque.offerLast(target);
        } else {
            if (deque.size() == capacity) {
                ElementLRU removed = deque.removeFirst();
                map.remove(removed.key);
                ElementLRU offered = new ElementLRU(key, value);
                deque.offerLast(offered);
                map.put(key, offered);
            } else {
                ElementLRU offered = new ElementLRU(key, value);
                deque.offerLast(offered);
                map.put(key, offered);
            }
        }
    }
    public static void main(String[] args) {


        LC0146_LRU_CacheDeque cache = new LC0146_LRU_CacheDeque(4);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }
}
