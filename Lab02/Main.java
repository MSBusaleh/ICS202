public class Main {
    public static void main(String[] args) throws Exception {
        SLL<Integer> mySll = new SLL<>();
        mySll.addToTail(7);
        mySll.addToTail(5);
        mySll.addToTail(3);
        mySll.addToTail(50);
        mySll.addToTail(7);
        mySll.addToTail(9);

        System.out.println("Original Integer array: " + mySll.toString());

        mySll.insertBefore(4, 20);
        System.out.println("After inserting 20 before index 4: " + mySll.toString());

        System.out.println("Element deleted from index 4: " + mySll.delete(4));

        System.out.println("After deleting element from index 4:" + mySll.toString());

        mySll.insertAfterSecondOccurrence(30, 7);
        System.out.println("After inserting 30 after the second occurrence of 7: " + mySll.toString());

    }
}