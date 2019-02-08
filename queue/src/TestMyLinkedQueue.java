import java.util.Iterator;

/**
 * This program demonstrates a test for MyLinkedQueue.
 */
public class TestMyLinkedQueue {
    public static void main(String[] args) {
        MyLinkedQueue<String> linkedQueue = new MyLinkedQueue<>();

        // add 10, 20, 30, 40, 50 to the queue
        linkedQueue.offer("10");
        linkedQueue.offer("20");
        linkedQueue.offer("30");
        linkedQueue.offer("40");
        linkedQueue.offer("50");

        // test peek()
        System.out.println("peek: " + linkedQueue.peek());

        // test poll()
        System.out.println("poll: " + linkedQueue.poll());
        System.out.println("poll: " + linkedQueue.poll());

        // test offer()
        linkedQueue.offer("90");

        // test size()
        System.out.println("size: " + linkedQueue.size());

        // test isEmpty()
        System.out.println("isEmpty: " + linkedQueue.isEmpty());

        // print the queue
        linkedQueue.printLinkedQueue();

        // forward iteration
        Iterator<String> it = linkedQueue.iterator();
        while (it.hasNext()) {
            String data = it.next();
            System.out.print(data + " ");
        }
        System.out.println();

        System.out.println("-----------------------------------");

        // reverse iteration
        Iterator<String> it2 = linkedQueue.reverseIterator().iterator();
        while (it2.hasNext()) {
            String data = it2.next();
            System.out.print(data + " ");
        }
        System.out.println();
        // for (String data : linkedQueue.reverseIterator()) {
        //     System.out.print(data + " ");
        // }
    }
}
