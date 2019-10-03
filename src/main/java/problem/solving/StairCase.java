package problem.solving;

import java.util.*;

public class StairCase {

    // Complete the staircase function below.
    static void staircase(int n) {
        int spaceLen = 1;
        for (int i = 0; i < n; i++, spaceLen++) {
            for (int s = spaceLen; s < n; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
                // System.out.print(" ");
            }
            System.out.println("#");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

