import java.net.DatagramSocket;
import java.util.Iterator;

/**
 * This program demonstrates a self-defined queue, using circular doubly linked list to implement linked queue.
 */
public class MyLinkedQueue<T> implements Iterable<T> {
    // the first element
    private Node first;
    // the last element
    private Node last;
    // the total number of elements
    private int counter;

    // use inner class to define the node in the linked queue
    private final class Node {
        private T data;
        private Node prev;
        private Node next;

        /**
         * Constructor with one parameter.
         */
        public Node(T data) {
            this.data = data;
        }

        /**
         * Constructor with parameters.
         */
        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Gets the total number of elements in the linked queue.
     *
     * @return the total number of elements
     */
    public int size() {
        return counter;
    }

    /**
     * Determines whether the linked queue is empty.
     *
     * @return if the queue is empty, return true; if not, return false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds a new element at the right end of the queue.
     *
     * @param data element value
     */
    public void offer(T data) {
        if (isEmpty()) {
            Node node = new Node(data);
            node.prev = node;
            node.next = node;
            first = last = node;
        } else {
            Node node = new Node(data, last, first);
            last.next = node;
            first.prev = node;
            last = last.next;
        }
        counter++;
    }

    /**
     * Gets the data in first(very left) element and deletes the first(very left) element in the queue.
     *
     * @return the data in first(very left) element
     */
    public T poll() {
        T data;
        if (isEmpty()) {
            System.out.println("The linked queue is empty!");
            return null;
        } else if (counter == 1) {
            data = last.data;
            first = last = null;
        } else {
            data = first.data;
            first.next.prev = last;
            last.next = first.next;
            first = first.next;
        }
        counter--;
        return data;
    }

    /**
     * Gets the data in first element in the queue.
     *
     * @return the data in first element
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return first.data;
        }
    }

    /**
     * Prints all the elements in a linked queue.
     */
    public void printLinkedQueue() {
        if (isEmpty()) {
            System.out.println("The linked queue to be printed is empty!");
        } else {
            Node current = first;
            for (int i = 0; i < counter; i++) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
        System.out.println();
    }

    /**
     * Forward iteration in a linked queue
     * The iterator which is used to traverse all the elements in a linked queue.
     *
     * @return iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = counter;
            Node current = first;

            @Override
            public boolean hasNext() {
                return count != 0;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                count--;
                return data;
            }
        };
    }

    /**
     * Reverse iteration in a linked queue.
     * The iterator which is used to traverse all the elements in a linked queue.
     *
     * @return iterable instance
     */
    public Iterable<T> reverseIterator() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int count = counter;
                    Node current = last;

                    @Override
                    public boolean hasNext() {
                        return count != 0;
                    }

                    @Override
                    public T next() {
                        T data = current.data;
                        current = current.prev;
                        count--;
                        return data;
                    }
                };
            }
        };
    }
}
