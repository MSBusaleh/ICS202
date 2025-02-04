public class dublicate {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<>();
        list.addToTail(7);
        list.addToTail(5);
        list.addToTail(3);

        list.printAll();
        dublicateThis(list);
        list.printAll();
    }

    public static void dublicateThis(DLL<Integer> list){
        DLLNode p = list.head;
    }
}
