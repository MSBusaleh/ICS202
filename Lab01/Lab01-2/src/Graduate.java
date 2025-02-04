public class Graduate extends Student{
    String status;

    public Graduate(String ID, double GPA){
        super(ID, GPA);

        if(GPA >= 3.00){status = "good";}
        else{status = "probation";}
    }

    @Override
    public String getStatus() {
        return status;
    }
}
