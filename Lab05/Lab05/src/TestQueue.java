public class TestQueue {
    public static void main(String[] args) {
        QueueAsArray<Integer> myQueue = new QueueAsArray<>(5);
        for(int i = 0; i < 5; i++)
            myQueue.enqueue((int)(1+Math.random()*11));

        System.out.println("The queue is:  " + myQueue);
        System.out.println("First dequeue element is: " + myQueue.dequeue());
        System.out.println("Second dequeue element is: " + myQueue.dequeue());
        System.out.println("The queue after dequeuing two elements is:  " + myQueue);
        System.out.println("The element at the front is: " + myQueue.peek());
    }
}