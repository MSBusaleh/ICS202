import java.util.ArrayList;
import java.util.Scanner;

public class postfix {
    public static void main(String[] args) {
        //Operators list
        ArrayList<String> ops = new ArrayList<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        //Read the expression and store it and make an iterator
        LabStack<Integer> numsStack = new LabStack<>();
        Scanner input = new Scanner(System.in);
        int num1, num2;
        System.out.print("Write your postfix expression:  ");
        String exp = input.nextLine();
        Scanner expLit = new Scanner(exp);
        boolean isValid = true;

        //Iterate over the expression
        while(expLit.hasNext() && isValid){
            String c = expLit.next();
            try{
                numsStack.push(Integer.valueOf(c)); //If the token is a number, store it in the stack
            }
            catch (Exception e){ //If the token is a sign, operate based on it
                try{
                num2 = numsStack.pop();
                num1 = numsStack.pop();
                switch (ops.indexOf(c)) {
                    case 0 -> numsStack.push(num1 + num2);
                    case 1 -> numsStack.push(num1 - num2);
                    case 2 -> numsStack.push(num1 * num2);
                    case 3 -> numsStack.push(num1 / num2);
                }
                }catch(Exception e1){
                    System.out.println("The expression is not valid");
                    isValid = false;
                }

                if(isValid)
                    System.out.println("The stack currently is: " + numsStack.toString());
            }
        }
        if(isValid)
            System.out.println(exp + "  =  " + numsStack.pop()); //Show result

    }
}
