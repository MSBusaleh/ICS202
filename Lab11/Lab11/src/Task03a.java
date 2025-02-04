import java.util.Scanner;

public class Task03a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        generateProperSuffixPrefix(pattern);
    }

    static void generateProperSuffixPrefix(String s) {
        int n = s.length();

        System.out.println("Substring: ");
        System.out.println("-------------------------------");

        for (int i = 1; i < n; i++) {
            String substring = s.substring(0, i);
            System.out.println("Substring: " + substring);

            System.out.println("Proper prefix-suffix pairs:");
            System.out.println("-------------------------------");

            for (int j = 1; j <= i; j++) {
                String prefix = substring.substring(0, j);
                String suffix = substring.substring(i - j, i);

                if (prefix.equals(suffix)) {
                    System.out.println(
                            "Proper prefix: " + prefix +
                            ", Proper suffix: " + suffix +
                            " *" + prefix.length());
                }
            }

            System.out.println("-------------------------------");
        }
    }
}
