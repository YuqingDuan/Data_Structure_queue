import java.lang.reflect.Array;

/**
 * This program demonstrates a self-defined queue, using array to implement a sequence queue.
 */
public class MyQueue<T> {
    // use array to implement a sequence queue
    private T[] objectArray;
    // the number of elements in the queue
    private int counter;

    /**
     * Constructor with given parameters.
     */
    public MyQueue(Class<T> clazz, int size) {
        // public static Object newInstance(Class<?> componentType, int length)
        // create a new array with the specified component type and length
        objectArray = (T[]) Array.newInstance(clazz, size);
        counter = 0;
    }

    /**
     * Adds a new element at the end of the queue.
     *
     * @param data element need to be added
     */
    public boolean offer(T data) {
        if (counter != objectArray.length) {
            objectArray[counter++] = data;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns and deletes the first element in the queue.
     *
     * @return the first element
     */
    public T poll() {
        if (counter == 0) {
            return null;
        } else {
            T firstElement = objectArray[0];
            counter--;
            // the other elements move forward one unit respectively
            for (int i = 0; i < counter; i++) {
                objectArray[i] = objectArray[i + 1];
            }
            return firstElement;
        }
    }

    /**
     * Gets the first element in the queue.
     *
     * @return the first element
     */
    public T peek() {
        if (counter != 0) {
            return objectArray[0];
        } else {
            return null;
        }
    }

    /**
     * Gets the number of the elements in the queue.
     *
     * @return the number of the elements in the queue
     */
    public int size() {
        return counter;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return if the queue is empty, return true; if not, return false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Traverses and prints the elements in the queue.
     */
    public void traverseQueue() {
        if (counter == 0) {
            System.out.println("The queue is empty!");
        } else {
            for (int i = 0; i < counter; i++) {
                System.out.print(objectArray[i] + " ");
            }
        }
    }
}
