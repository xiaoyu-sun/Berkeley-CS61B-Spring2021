package deque;

public class LinkedListDeque<T> {

    public class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        // The "prev" of the original first node should now point to new first node
        sentinel.next.prev = newNode;
        // The "next" of sentinel node should also point to new first node
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        // The "next" of the original last node should now point to new last node
        sentinel.prev.next = newNode;
        // The "prev" of sentinel node should also point to new last node
        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.println("Mason");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T firstItem = sentinel.next.item;
        // The next of sentinel node should now point to the original second node
        sentinel.next = sentinel.next.next;
        // The prev of the original second node should now point to sentinel
        sentinel.next.prev = sentinel;
        size -= 1;

        return firstItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T lastItem = sentinel.prev.item;
        // The prev of sentinel should now point to original second to last node
        sentinel.prev = sentinel.prev.prev;
        // The next of original second to last node should now point to sentinel
        sentinel.prev.next = sentinel;
        size -= 1;

        return lastItem;
    }


}
