import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    private AVLTree<String> words;

    //Constructors
    public Dictionary() {
        words = new AVLTree<>();
        System.out.println("Dictionary was successfully constructed");
    }

    public Dictionary(String s) {
        words = new AVLTree<>();
        words.insertAVL(s.toLowerCase());
        System.out.println("\nDictionary was successfully constructed");
    }

    public Dictionary(File infile) {
        words = new AVLTree<>();
        try (Scanner s = new Scanner(infile)){
            System.out.println("LOADING FILE . . .");

            while (s.hasNext())
                words.insertAVL(s.next().toLowerCase());

            System.out.println("The Dictionary was successfully loaded");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("\n\n404\nFile not found, please check the file name, path," +
                    "\nand make sure to include the extentions\n");
        }
    }



    //Methods
    public void addWord(String s) {
        //Only lowerCase is added to avoid problems
        s = s.toLowerCase();
        if(!words.isInTree(s)){
            words.insertAVL(s);
            System.out.printf("the word (%s) was Added successfully", s);
        }
        else
            System.out.println("This word already exist in the dictionary");
    }

    public boolean findWord(String s) {return words.isInTree(s.toLowerCase());}

    public void deleteWord(String s) {words.deleteAVL(s.toLowerCase());}

    public ArrayList<String> findSimilar(String s) {

        s = s.toLowerCase();
        ArrayList<String> similarWords = new ArrayList<>();
        ArrayList<String> allWords = words.inorder();

        for (String currentWord : allWords) {
            if (!s.equals(currentWord)) {
                int letterDifference = Math.abs(s.length() - currentWord.length()), currentIdx = 0,
                        maxLength = Math.min(s.length(), currentWord.length());//To Avoid indexOutOfBounds we take the shorter word

                while (letterDifference <= 1 && currentIdx < maxLength) {
                    if (s.charAt(currentIdx) != currentWord.charAt(currentIdx))
                        letterDifference++;
                    currentIdx++;
                }

                if (letterDifference <= 1)
                    similarWords.add(currentWord);
            }
        }

        return similarWords;
    }

    public void writeToFile(String s) throws Exception {
        //Add extention if it's not there
        if (!s.contains("."))
            s = s + ".txt";
        PrintWriter outFile;

        try {
            outFile = new PrintWriter(new File(s)); //open the file
        } catch (FileNotFoundException e) {
            outFile = new PrintWriter(s); // if the file does not exist, creat new file
        }

        //get all the words and add them to the file
        ArrayList<String> wordsList = words.inorder();
        for (String newWord : wordsList){
            outFile.println(newWord);
        }
        outFile.close();

        System.out.println("Changes saved successfully!\nYou have just used the best Dictionary class ever.");
    }


    public static void main(String[] args) {
        //The following are for readability purposes only
        final String EMPTY_DIC = "1", ONE_WORD_DIC = "2", FILE_DIC = "3",
                ADD_WORD = "1", CHECK_WORD_IS_IN_DIC = "2", FIND_SIM = "3", DELETE_WORD = "4", SAVE = "5";
        //These are constants for readability in the switch function

        //Initializers
        Dictionary dic = null; //our dictionary to work with
        Scanner input = new Scanner(System.in); //to Read user input
        boolean correctInput = false, changesSaved = false;// To check if input is correct, To end the program when finished
        String currentInput; //Keep track of the input

        //Starting Menu
        System.out.println(
                """
                        How would you like to initialize you dictionary:
                           1 - Create empty dictionary.
                           2 - Create Single-word dictionary.
                           3 - Upload dictionary from a file.
                        """);

        //intialize the dictionary based on the user choice
        while (!correctInput) {
            //promt the user to enter his choice from the shown menu, and store it
            System.out.print("Please enter the number only:  ");
            String currentInp = input.next();

            //Act based on the number entered by the user
            switch (currentInp) {
                case EMPTY_DIC -> {
                    correctInput = true;
                    dic = new Dictionary();
                }

                case ONE_WORD_DIC -> {
                    correctInput = true;
                    System.out.println("Enter the first word in your dictionary: ");
                    dic = new Dictionary(input.next());
                }

                case FILE_DIC -> {
                    correctInput = true;
                    System.out.println("Enter the file you want to upload (Make sure you enter the whole path): ");
                    dic = new Dictionary(new File(input.next()));
                }

                default -> System.out.println("WORNG INPUT!");//If the user entry != 1, 2, or 3
            }
        }

        //Actions menu after constructing the dicitonary
        System.out.println(
                """           
                                                
                        Now, what would you like to do:
                           1 - Add a new word to the dictionary.
                           2 - Check if a word is in the dictionary.
                           3 - Find similarities of a specific word.
                           4 - Delete a word from the dictionary.
                           5 - Save the dictionary to a file.
                        """);


        //The program will keep going until the user save the changes to a file
        while (!changesSaved) {

            //promt the user to enter his choice from the shown menu, and store it
            System.out.print("\nPlease enter the number only: ");
            currentInput = input.next();

            //Act based on the user input
            switch (currentInput) {

                case ADD_WORD -> {
                    System.out.print("\nEnter the word you'd like to add:  ");
                    dic.addWord(input.next());
                    System.out.print("\n\n\nWhat else would you like to do from the previous list?");
                }

                case CHECK_WORD_IS_IN_DIC -> {
                    System.out.print("\nEnter the word you'd like to find:  ");
                    boolean wordFound = dic.findWord(input.next());

                    if (wordFound)
                        System.out.print("The word does exist in the dictionary");
                    else
                        System.out.print("The word does not exist in the dictionary");

                    System.out.print("\n\n\nWhat else would you like to do from the previous list?");
                }

                case FIND_SIM -> {
                    System.out.print("\nEnter the word you'd like to find similarities to: ");
                    ArrayList<String> simWords = dic.findSimilar(input.next());//Get similar words in a list

                    if (simWords.isEmpty())
                        System.out.println("No similarities were found.");

                    else {
                        System.out.print("The similar words are:  ");
                        for (String word : simWords)
                            System.out.print(word + " ");
                    }

                    System.out.print("\n\n\nWhat else would you like to do from the previous list?");
                }

                case DELETE_WORD -> {
                    System.out.print("\nEnter the word you'd like to delete: ");
                    dic.deleteWord(input.next());
                    System.out.print("\n\n\nWhat else would you like to do from the previous list?");
                }

                case SAVE -> {
                    System.out.print("Are you sure you want to Save the dictionary and end the session (Y/N): ");
                    if (!input.next().equalsIgnoreCase("Y")) {//The user would like to make more edits
                        currentInput = "0"; //To not start the saving-to-file procedure
                        System.out.print("\n\n\nWhat else would you like to do from the previous list?");
                    }
                }
                default -> {
                    System.out.println("WRONG INPUT!");
                }
            }

            //saving-to-file process
            if (currentInput.equals("5")) {
                System.out.println("Please enter the desired file name\n(Note: if there is no file with the given name, a new one will be created)");

                try {
                    dic.writeToFile(input.next());
                    changesSaved = true;
                } catch (Exception e) {
                    System.out.println("Error Encountered, changes are unsaved");
                }
            }
        }
    }
}
