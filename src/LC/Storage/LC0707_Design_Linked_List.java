package LC;

public class LC0707_Design_Linked_List {
    class MyLinkedList {
        class Node {
            int val;
            Node next;
            Node prev;
            public Node(int val) {
                this.val = val;
                next = null;
                prev = null;
            }
        }

        Node head;
        Node tail;
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public Node getNode(int index) {
            if (size == 0 || index < 0 || index > size - 1) {
                return null;
            }
            Node target = head;
            for (int i = 0; i <= index; i++) {
                target = target.next;
            }
            return target;
        }
        public int get(int index) {
            Node result = getNode(index);
            return result == null ? -1 : result.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val);
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node node = new Node(val);
            Node temp = tail.prev;
            tail.prev = node;
            node.next = tail;
            node.prev = temp;
            temp.next = node;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            Node newNode = new Node(val);
            if (index == size) {
                Node tempPrev = tail.prev;
                tail.prev = newNode;
                newNode.next = tail;
                tempPrev.next = newNode;
                newNode.prev = tempPrev;
                size++;
            } else {

                Node baseNode = getNode(index);
                Node tempPrev = baseNode.prev;
                newNode.next = baseNode;
                baseNode.prev = newNode;
                newNode.prev = tempPrev;
                tempPrev.next = newNode;
                size++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (size == 0 || index < 0 || index > size - 1){
                return;
            }
            Node target = getNode(index);
            Node prev = target.prev;
            Node next = target.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
