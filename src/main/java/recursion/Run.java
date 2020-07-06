package recursion;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        makeAnogram("cat");
    }
    

    public static int findTriangleNumber(int n) {
        if (n == 1) return 1;
        return n + findTriangleNumber(n - 1);
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1) ;
    }

    public static int loopFactorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static void makeAnogram(String word) {
        String[] split = word.split("");

        for (int i = 0; i < split.length - 1; i++) {
            String tmp = split[i];
            split[i] = split[i + 1];
            split[i + 1 ] = tmp;
            String newString = Arrays.toString(split);
            rotate(newString);
        }
    }
    static void rotate(String word) {
        String[] split = word.split("");
        for (int i = split.length - 1; i > 0; i--) {
            String tmp = split[i];
            split[i] = split[i -1];
            split[i - 1 ] = tmp;
            System.out.println();
        }
    }
}



