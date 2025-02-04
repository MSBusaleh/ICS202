public class Undergraduate extends Student{
    String status;

    public Undergraduate(String ID, double GPA){
        super(ID, GPA);

        if(GPA >= 3.00){status = "honor";}
        else if(GPA >= 2.00){status = "good";}
        else{status = "probation";}
    }

    @Override
    public String getStatus() {
        return status;
    }
}
