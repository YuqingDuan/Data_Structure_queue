/**
 * This program demonstrates a test for MyQueue.
 */
public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>(java.lang.String.class, 12);

        // add 10, 20, 30, 40, 50 to the queue
        queue.offer("10");
        queue.offer("20");
        queue.offer("30");
        queue.offer("40");
        queue.offer("50");

        // test peek()
        System.out.println("peek: " + queue.peek());

        // test poll()
        System.out.println("poll: " + queue.poll());
        System.out.println("poll: " + queue.poll());

        // test offer()
        System.out.println("offer: " + queue.offer("90"));

        // test size()
        System.out.println("size: " + queue.size());

        // test isEmpty()
        System.out.println("isEmpty: " + queue.isEmpty());

        // print the queue
        queue.traverseQueue();
    }
}
