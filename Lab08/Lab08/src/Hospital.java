import java.util.Arrays;

public class Hospital {
    public static void main(String[] args) {
        String[] names = {"Mohammed", "Ali", "Fatima", "Hassan", "Hussain",
                "Abdullah", "Ashiq", "Bassam", "Jawad", "Essa"};

        Patient[] pList = new Patient[10];
        for(int i = 0; i < 10; i++)
            pList[i] = new Patient(names[i], (int)(1 + Math.random() * 5));

        BinaryHeap pHeap = new BinaryHeap(pList.length);
        System.out.println("The Original order");
        for(Patient p: pList) {
            System.out.println(p);
            pHeap.enqueue(p);
        }

        Comparable sorted_pList[] = pHeap.heapSort();
        System.out.println("\n\nThe SORTED order");
        for(Comparable i: sorted_pList)
            System.out.println(i);
    }
}