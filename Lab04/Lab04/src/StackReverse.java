import java.util.Scanner;

public class StackReverse {
    public static void main(String[] args) {
        LabStack<String> org = new LabStack<>();
        LabQueue<String> reversed = new LabQueue<>();

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter your input:  ");
        String inp = input.nextLine();
        Scanner reader = new Scanner(inp);

        //Iterate over the input
        while(reader.hasNext()){
            org.push(reader.next());
        }
        System.out.print("\n     Your stack is:     " + org.toString());

        //Store stack elements in a queue & back to the stack
        while(!org.isEmpty()){
            reversed.enqueue(org.pop());
        }
        while(!reversed.isEmpty()){
            org.push(reversed.dequeue());
        }

        //Print reversed elements
        System.out.println("\n\nYour Reversed stack is: " + org.toString());
    }
}
