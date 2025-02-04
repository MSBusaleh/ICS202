public class Patient implements Comparable {
    String name;
    int emergencyLvl;

    public Patient(String name, int emergencyLvl){
        this.name = name;
        this.emergencyLvl = emergencyLvl;
    }

    @Override
    public int compareTo(Object o) {
        Patient p = (Patient) o;
        if(this.emergencyLvl == p.emergencyLvl)
            return this.name.compareTo(p.name);
        else if(this.emergencyLvl < p.emergencyLvl)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Patient" +
                " Name>>  " + name +
                ", Emergency Level>> " + emergencyLvl;
    }
}
