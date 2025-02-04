import java.util.Scanner;

public class Task01{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text pattern: ");
        String text = scanner.nextLine();

        String longestPrefixSuffix = findPrefix(text);

        if (longestPrefixSuffix != null) {
            System.out.println("Longest non-overlapping suffix that is also a prefix is: " +
                    longestPrefixSuffix + " its length is: " + longestPrefixSuffix.length());
        } else {
            System.out.println("No non-overlapping suffix that is also a prefix.");
        }
    }

    private static String findPrefix(String text) {
        int n = text.length();

        for (int i = n / 2; i > 0; i--) {
            String prefix = text.substring(0, i);
            String suffix = text.substring(n - i);

            if (prefix.equals(suffix)) {
                return prefix;
            }
        }

        return null;
    }
}
