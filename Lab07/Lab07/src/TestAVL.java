import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestAVL {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        //Example which works with Left Rotation
        AVLTree<String> t = new AVLTree<String>();
        for (int i = 1; i <= 5; i++)
            t.insertAVL("a" + i);
        t.breadthFirst();
        System.out.println();

        System.out.println("\n\nExercise 2");
        AVLTree<Integer> numAVL = new AVLTree<>();
        int[] values = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};
        for (int i : values)
            numAVL.insertAVL(i);

        numAVL.breadthFirst();

        System.out.print("\n\nEnter Three elements to be deleted for the AVL: ");
        int el1 = inp.nextInt(), el2 = inp.nextInt(), el3 = inp.nextInt();
        numAVL.deleteAVL(el1);
        numAVL.deleteAVL(el2);
        numAVL.deleteAVL(el3);
        System.out.print("The AVL after deleting the elements: ");
        numAVL.breadthFirst();



        System.out.println("\n\nExercise 3");
        AVLTree<String> wordsAVL = new AVLTree<>();
        try {
            Scanner inpFile = new Scanner(new File("sampletextfile.txt"));
            while(inpFile.hasNext()){
                String word= inpFile.next();
                if(!wordsAVL.isInTree(word)){
                    wordsAVL.insertAVL(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        wordsAVL.inorder();

        //read the text file, insert unique words into the AVL tree and print its inorder traversal
    }
}