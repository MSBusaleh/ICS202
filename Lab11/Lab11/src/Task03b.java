import java.util.Arrays;

public class Task03b {
    public static void main(String[] args) {
        String[] words = {"ABCDE", "AAAAA", "ABABAMK"};

        for (String word: words)
            System.out.printf("The next array for '%s' is %s\n",
                    word, Arrays.toString(computeNextArray(word)));

    }

    public static int[] computeNextArray(String x){
        int[] next = new int[x.length() + 1];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < x.length()){
            while(j == -1 || i < x.length() && (x.charAt(i) == x.charAt(j))){
                i++;
                j++;
                next[i] = j;
            }

            j = next[j];
        }

        return next;
    }

}
