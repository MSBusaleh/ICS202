import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text string T: ");
        String text = scanner.nextLine();

        System.out.print("Enter a pattern string P: ");
        String pattern = scanner.nextLine();

        int occurrences = searchPattern(text, pattern);

        if (occurrences == 0) {
            System.out.println("Pattern not found.");
        }
    }

    private static int searchPattern(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int occurrences = 0;

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == patternLength) {
                printMatch(text, pattern, i);
                occurrences++;
            }
        }

        return occurrences;
    }

    private static void printMatch(String text, String pattern, int startIndex) {
        System.out.println(text);
        for (int i = 0; i < startIndex; i++) {
            System.out.print(" ");
        }
        System.out.println(pattern);
        for (int i = 0; i < startIndex; i++) {
            System.out.print(" ");
        }
        System.out.println(startIndex);
        System.out.println();
    }
}


