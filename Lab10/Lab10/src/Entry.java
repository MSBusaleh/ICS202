import java.util.Arrays;
import java.util.Objects;

public class Entry<T> {
    private T dataObject;
    private String status;

    public Entry(){
        status = "E";
    }

    public boolean setData(T dataObject){
        boolean taskDone = false;

        if(status.equals("E") || status.equals("D")) {
            this.dataObject = dataObject;

            taskDone = true;
        }

        return taskDone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public T getDataObject() {
        return dataObject;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        Object[] entities = {dataObject, status};
        return Arrays.toString(entities);
    }
}
