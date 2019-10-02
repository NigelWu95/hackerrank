package problem.solving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimMSTTest {

    public static void main(String[] args) throws Exception {

        test1();
        test2();
    }

    public static void test1() {

//        int[][] edges = {{2, 1, 1000}, {3, 4, 299}, {2, 4, 200}, {2, 4, 100}, {3, 2, 300}, {3, 2, 6}};
//        int n = 4;
//        int[][] edges = {{1, 2, 1}, {3, 2, 150}, {4, 3, 99}, {1, 4, 100}, {3, 1, 200}};
//        int n = 4;
        int[][] edges = {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        int n = 5;
//        int[][] edges = {{1, 2, 20}, {1, 3, 50}, {1, 4, 70}, {1, 5, 90}, {2, 3, 30}, {3, 4, 40}, {4, 5, 60}};
//        int n = 5;
        System.out.println("Solution1: " + n + " --- " + PrimMSTSolution1.prims(n, edges, 1));
        System.out.println("Solution2: " + n + " --- " + PrimMSTSolution2.prims(n, edges, 1));
        System.out.println("Solution3: " + n + " --- " + PrimMSTSolution3.prims(n, edges, 1));
        System.out.println("Solution4: " + n + " --- " + PrimMSTSolution4.prims(n, edges, 1));
    }

    public static void test2() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("/Users/wubingheng/Downloads/input05.txt"));
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }
        int start = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("Solution4: " + n + " --- " + PrimMSTSolution4.prims(n, edges, start));
        scanner.close();
    }
}
