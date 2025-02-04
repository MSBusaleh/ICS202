import java.util.Arrays;

public class BinaryHeap {
    protected Comparable array[];
    int count;

    public BinaryHeap(int i) {
        array = new Comparable[i + 1];
    }

    public BinaryHeap(Comparable[] comparable) {
        this(comparable.length);
        for (int i = 0; i < comparable.length; i++)
            array[i + 1] = comparable[i];

        count = comparable.length;

        //buildHeapTopDown(); //PART OF Q. 1
        buildHeapBottomUp();
    }

    private void buildHeapBottomUp() {
        int currentIdx = array.length / 2, leftChild, rightChild;
        boolean moreThanLeft, moreThanRight = false;
        while(currentIdx > 0){
            leftChild = 2 * currentIdx; rightChild = leftChild + 1;

            moreThanLeft = array[currentIdx].compareTo(array[leftChild]) == 1;

            if(rightChild < array.length)
                moreThanRight = array[currentIdx].compareTo(array[rightChild]) == 1;

            if(moreThanLeft || moreThanRight)
                percolateDown(currentIdx);

            currentIdx--;
        }

    }

    private void buildHeapTopDown() {
        int parentIdx, currentIdx = 0;
        for (Comparable i : array) {
            parentIdx = currentIdx / 2;
            if (parentIdx != 0 && array[currentIdx].compareTo(array[parentIdx]) == -1) {
                percolateUp(currentIdx);
            }
            currentIdx++;
        }
    }

    private void percolateDown(int index) {
        int child = 2 * index; //set right child as default min
        Comparable temp;

        if(child + 1 < array.length && array[2 * index].compareTo(array[2*index + 1]) == 1)
            child = 2 * index + 1;

        while(child < array.length && array[index].compareTo(array[child]) == 1){
            temp = array[index];
            array[index] = array[child];
            array[child] = temp;
            index = child;
            child = 2 * index;
            if(child + 1 < array.length && array[child].compareTo(array[child + 1]) == 1)
                child = 2 * index + 1;
        }
    }

    private void percolateUp(int index) {
        int parent = index/2;
        Comparable temp;
        while(parent != 0 && array[index].compareTo(array[parent]) == -1){
            temp = array[index];
            array[index] = array[parent];
            array[parent] = temp;
            index = parent;
            parent = index/2;
        }
    }

    public void purge() {
        while (count > 0)
            array[count--] = null;
    }

    public void enqueue(Comparable comparable) {
        int index = ++count;

        //percolate up via a gap
        while (index > 1 && array[index / 2].compareTo(comparable) > 0) {
            array[index] = array[index / 2];
            index = index / 2;
        }

        array[index] = comparable;
    }

    public Comparable findMin() {
        return array[1];
    }

    public Comparable dequeueMin() {
        Comparable minItem = array[1];
        array[1] = array[count];
        count--;
        percolateDown(1);
        return minItem;
    }

    public Comparable[] heapSort() {
        Comparable[] x = new Comparable[count];
        int total = count;
        for (int i = 0; i < total; i++) {
            x[i] = dequeueMin();
        }
        return x;
    }


    public boolean isFull() {
        return count == array.length - 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        Comparable[] tempArray = new Comparable[array.length - 1];
        System.arraycopy(array, 1, tempArray, 0, array.length - 1);
        return Arrays.toString(tempArray);
    }

    public static void main(String[] args) {
        Integer[] a = {10, 2, 8, 9, 1, 6, 3, 4, 0, 5};
        System.out.println("The original array is: " + Arrays.toString(a));
        BinaryHeap bh = new BinaryHeap(a);
        //builds heap bottom up: change the constructor to build it top-down
        System.out.println("\nThe heap is: " + bh);
        System.out.println("\nSorted Array is: "+Arrays.toString(bh.heapSort()));
    }
}