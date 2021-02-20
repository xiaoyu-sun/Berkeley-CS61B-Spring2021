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

    public void expand() {
        return;  // TO BE IMPLEMENTED
    }

    public void contract() {
        return;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            expand();
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            expand();
        }
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
        if (items.length >= 16 && size <= items.length * 0.25) {
            contract();
        }
        return itemToRemove;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
        T itemToRemove = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (items.length >= 16 && size <= items.length * 0.25) {
            contract();
        }
        return itemToRemove;
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        // calculate the target location in the underlying array
        int location = nextFirst + 1 + index;
        if (location >= items.length) {
            location -= items.length;
        }
        return items[location];
    }
}
