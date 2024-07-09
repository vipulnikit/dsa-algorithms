import java.util.HashMap;

public class LRUCache {
    class ListNode {
        int key, val;
        ListNode prev, next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    ListNode head, tail;
    HashMap<Integer, ListNode> keyValueMap;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null; tail = null;
        keyValueMap = new HashMap<>();
    }
    
    // TC of all methods: O(1)
    // SC: O(capacity)
    public int get(int key) {
        if (keyValueMap.containsKey(key)) {
            ListNode valueNode = keyValueMap.get(key);
            if (tail != valueNode) {
                ListNode deletedElement = removeElement(valueNode);
                insertMRUElment(deletedElement);
            }
            return tail.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        ListNode foundElement = keyValueMap.get(key);
        if (foundElement != null) {
            ListNode deletedElement = removeElement(foundElement);
            deletedElement.val = value;
            insertMRUElment(deletedElement);
            keyValueMap.put(key, deletedElement);
        } else {
            ListNode newNode = new ListNode(key, value);
            if (capacity == keyValueMap.size()) {
                ListNode deletedElement = removeElement(head);
                keyValueMap.remove(deletedElement.key);
            }
            insertMRUElment(newNode);
            keyValueMap.put(key, newNode);
        }
    }

    public ListNode removeElement(ListNode valueNode) {
        if (valueNode == head && valueNode.next == null) {
            head = null;
            tail = null;
        } else if (valueNode == head) {
            head = head.next;
            head.prev = null;
        } else if (valueNode == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            valueNode.prev.next = valueNode.next;
            valueNode.next.prev = valueNode.prev;
        }
        return valueNode;
    }

    public void insertMRUElment(ListNode newNode) {
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }
}
