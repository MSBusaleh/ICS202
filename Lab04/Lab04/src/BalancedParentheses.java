import java.util.ArrayList;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {

        //Create lists of parentheses
        ArrayList<String> open = new ArrayList<>();
        open.add("(");
        open.add("[");
        open.add("{");

        ArrayList<String> close = new ArrayList<>();
        close.add(")");
        close.add("]");
        close.add("}");



        // Takes the input, store it and removes the non-parentheses characters
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your expression:  ");
        StringBuilder expression = new StringBuilder(input.nextLine());
        for(int i = 0; i <expression.length(); i++){
            String letter = String.valueOf(expression.charAt(i));
            if(!(close.contains(letter) || open.contains(letter))) {
                expression.delete(i, i + 1);
                i--;
            }
        }


        // Runs the function and shows whither the input is balanced or not
        if(isBalanced(expression.toString(), open, close))
            System.out.println("The expression is balanced");
        else
            System.out.println("The expression is not balanced");

    //FIN of main
    }

    public static boolean isBalanced(String exp, ArrayList<String> open, ArrayList<String> close){
        LabStack<String> parentheses = new LabStack<>();

        for(int i = 0; i <exp.length(); i++){ //loops throw the parentheses
            String letter = String.valueOf(exp.charAt(i));
            if(open.contains(letter)) //The encountered parentheses is open
                parentheses.push(letter);
            else if (close.contains(letter) && !parentheses.isEmpty()) {//The encountered parentheses is close and the stack is not empty
               if(!(close.indexOf(letter) == open.indexOf(parentheses.pop())))
                   return false;
            }
            else //The encountered parentheses is close and the stack is empty
                return false;
        }


        return parentheses.isEmpty(); //After the loop checks if the stack is empty
    }
}