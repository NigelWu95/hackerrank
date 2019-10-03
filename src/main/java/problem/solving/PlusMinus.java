package problem.solving;

import java.util.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int total = arr.length;
        float positive = 0f;
        float negative = 0f;
        float zero = 0f;
        for (int i = 0; i < total; i++) {
            if (arr[i] > 0) positive++;
            else if (arr[i] == 0) zero++;
            else negative++;
        }
        System.out.println(positive/total);
        System.out.println(negative/total);
        System.out.println(zero/total);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

