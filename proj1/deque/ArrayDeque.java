package deque;

public class ArrayDeque<T> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        size = 0;
        nextFirst = 3;
        nextLast = 4;
        items = (T[]) new Object[8];
    }

    public void resize(int capacity) {
        return;  // TO BE IMPLEMENTED
    }

    public void checkFull() {
        if (size == items.length) {
            resize(size * 2);
        }
    }

    public void checkCut() {
        if (size < items.length * 0.25) {
            resize(items.length / 4);
        }
    }

    public void addFirst(T item) {
        checkFull();
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    public void addLast(T item) {
        checkFull();
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast >= items.length) {
            nextLast = 0;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        return; // TO BE IMPLEMENTED
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst += 1;
        if (nextFirst >= items.length) {
            nextFirst = 0;
        }
        T itemToRemove = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        checkCut();
        return itemToRemove;
    }

    public T removeLast() {

    }
}
