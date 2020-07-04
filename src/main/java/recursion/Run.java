package recursion;

public class Run {
    public static void main(String[] args) {
        int n = findTriangleNumber(7);
        System.out.println(loopFactorial(5));
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

}



