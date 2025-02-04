public abstract class Student {
    String ID;
    double GPA;

    public Student(String ID, double GPA){
        this.ID = ID;
        this.GPA = GPA;
    }

    public double getGPA() {return GPA;}
    public String getID() {return ID;}

    abstract public String getStatus();

    final public String displayStudent(Student s){
        return(s.getClass() + " ID>> " + getID() + ", GPA>> " + getGPA() + ", Status>> " + getStatus());
    }
}
