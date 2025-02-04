import java.util.ArrayList;
import java.util.Scanner;

public class PreFix {
    public static void main(String[] args) {
        ArrayList<String> ops = new ArrayList<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");


        LabStack<String> opsStack = new LabStack<>();
        LabStack<Integer> numsStack = new LabStack<>();
        LabStack<String> all = new LabStack<>();

        int seqInt = 0, num1, num2;
        boolean topElInt;


        Scanner inp = new Scanner(System.in);
        System.out.print("Write your postfix expression:  ");
        String exp = inp.nextLine();
        Scanner expLit = new Scanner(exp);

        while(expLit.hasNext()){
            String c = expLit.next();
            try{
                numsStack.push(Integer.valueOf(c));
                all.push(String.valueOf(c));
                seqInt++;
            }
            catch (Exception e){
                opsStack.push(c);
                all.push(c);
                seqInt = 0;
            }

            while(seqInt == 2){
                num2 = numsStack.pop();
                num1 = numsStack.pop();
                for(int i = 0; i < 3; i++){all.pop();}
                int result = 0;

                switch (ops.indexOf(opsStack.pop())) {
                    case 0 -> result = (num1 + num2);
                    case 1 -> result = (num1 - num2);
                    case 2 -> result = (num1 * num2);
                    case 3 -> result = (num1 / num2);
                }
                numsStack.push(result);

                if(all.isEmpty() || ops.contains(all.topEl())){seqInt = 1;}
                all.push(String.valueOf(result));
            }
        }

        System.out.println(exp + "  =  " + numsStack.pop()); //Show result
    }
}
