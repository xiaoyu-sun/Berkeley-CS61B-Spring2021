package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {

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

    /** Doubles the length of current underlying array. */
    public void expand() {
        T[] a = (T[]) new Object[size * 2];
        if (nextLast == 0) {
            System.arraycopy(items, 0, a, 0, size);
            nextLast = size;
            nextFirst = items.length - 1;
        } else {
            System.arraycopy(items, 0, a, 0, nextLast);
            System.arraycopy(items, nextLast, a, nextLast + size, size - nextLast);
            nextFirst += size;
        }
        items = a;
    }

    /** Reduce the length of current underlying array by 75%. */
    public void contract() {
        T[] a = (T[]) new Object[items.length / 4 + 1];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, size);
        } else {
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextLast);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
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
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
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
        if (index > size - 1 || index < 0) {
            return null;
        }
        // calculate the target location in the underlying array
        int location = nextFirst + 1 + index;
        if (location >= items.length) {
            location -= items.length;
        }
        return items[location];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        public ArrayDequeIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
//        if (!Deque.class.isAssignableFrom(o.getClass())) {
//            return false;
//        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<?> newObj = (Deque<?>) o;
        if (this.size() != newObj.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!get(i).equals(newObj.get(i))) {
                return false;
            }
        }
//
//        try {
//            Deque<T> newObj = (Deque<T>) o;
//            if (this.size() != newObj.size()) {
//                return false;
//            }
//
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }
}
