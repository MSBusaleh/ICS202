import java.util.Collections;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        Student[] stList = new Student[10];

        for(int i = 0; i<10; i++){
            String randID = String.valueOf((int)(1000000000 * random() + 1000000));
            double randGPA = round((5.001 * random())*100.0)/100.0;

            if((int)(2*random()) == 1){
                stList[i] = new Undergraduate(randID, randGPA);
            }
            else{
                stList[i] = new Graduate(randID, randGPA);
            }
        }

        for(Student s:stList){
            System.out.println(s.displayStudent(s));
        }
    }
}