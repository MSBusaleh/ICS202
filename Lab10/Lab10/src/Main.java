public class Main {
    public static void main(String[] args) {
        HashTable<Integer> myHT = new HashTable<>(13);
        myHT.insert(18);
        myHT.insert(26);
        myHT.insert(35);
        myHT.insert(9);
        System.out.println("After insertion:");
        System.out.println(myHT.toString());

        myHT.find(15);
        myHT.find(48);
        myHT.delete(35);
        myHT.find(9);

        myHT.insert(64);
        myHT.insert(47);
        System.out.println("After deletion & insertion:");
        System.out.println(myHT.toString());

        myHT.find(35);
    }
}