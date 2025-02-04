import java.util.Arrays;

public class HashTable<T> {
    private Entry[] data;

    public HashTable(int size){
        data = new Entry[size];

        for(int i = 0; i < data.length; i++)
            data[i] = new Entry<>();
    }

    private int hashCodeGenerate(int number){
        return number%data.length;
    }

    public boolean insert(T dataObject){
        boolean taskDone;
        int num = (int)dataObject;
        int index = hashCodeGenerate(num);

        while(index < data.length
                && data[index].getStatus().equals("O")){
            num++;
            index = hashCodeGenerate(num);
        }


        try{
            data[index].setData(dataObject);
            data[index].setStatus("O");
            taskDone = true;
        }
        catch(Exception indexOutOfBounds){
            taskDone = false;
        }


        return taskDone;
    }

    public int findNextAvailableSlot(int currentslot){
        int nextAvailable = hashCodeGenerate(currentslot);

        while(nextAvailable < data.length
                && data[nextAvailable].getStatus().equals("O")){
            currentslot++;
            nextAvailable = hashCodeGenerate(currentslot);
        }

        if(nextAvailable>=data.length)
            nextAvailable = -1;

        return nextAvailable;
    }

    public boolean delete(T dataObject){
        int idx = find(dataObject);
        if(idx == -1){return false;}

        data[idx].setStatus("D");
        System.out.println("successfully deleted");
        return true;
    }

    public int find(T dataObject){
        int num = (int)dataObject, idx = hashCodeGenerate(num);
        String st = data[idx].getStatus();

        while(idx < data.length && !st.equals("E")){
            if(st.equals("O")
                    && data[idx].getDataObject().equals(dataObject)){
                System.out.println(dataObject + " was found at " + idx);
                return idx;
            }

            num++;
            idx = hashCodeGenerate(num);
            st = data[idx].getStatus();
        }

        System.out.println(dataObject + " is not found");
        return -1;
    }

    @Override
    public String toString() {
        System.out.println("HASHTABLE");
        for(int i = 0; i < data.length; i++)
            System.out.println(i + ":  " + data[i]);

        return "\n";
    }
}
