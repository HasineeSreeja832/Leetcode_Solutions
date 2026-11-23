import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }

    private int capacity;
    private int size;
    private int minFreq;

    private HashMap<Integer, Node> keyMap;
    private HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (size == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node lfuNode = list.removeLast();

            keyMap.remove(lfuNode.key);

            size--;
        }

        // Create new node
        Node newNode = new Node(key, value);

        keyMap.put(key, newNode);

        // New node always has frequency 1
        freqMap.putIfAbsent(1, new DoublyLinkedList());

        freqMap.get(1).addFirst(newNode);

        minFreq = 1;

        size++;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        // If this was the last node in the minimum-frequency list
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());

        freqMap.get(node.freq).addFirst(node);
    }
}