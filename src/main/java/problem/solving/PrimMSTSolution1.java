package problem.solving;

import java.io.*;
import java.util.*;

/**
 * 实现算法 1，相对来说已经从现有的节点列表中剔除了使用过的边，但时间复杂度仍然较高 O(n^3)
 */
public class PrimMSTSolution1 {

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {

        Set<Integer> nodeSet = new HashSet<Integer>(){{ add(start); }};
        Set<int[]> edgeSet = new HashSet<>();
        for (int[] edge : edges) {
            if (edge.length != 3) {
                throw new RuntimeException("wrong edge: " + Arrays.toString(edge));
            } else {
                if (edge[0] > n || edge[1] > n) {
                    throw new RuntimeException("wrong node num: " + edge[0]);
                } else {
                    edgeSet.add(edge);
                }
            }
        }
        int sum = 0;
        int min;
        int minIndex = 0;
        int[] minEdge = new int[3];
        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int id : nodeSet) {
                for (int[] edge : edgeSet) {
                    if (edge[2] < min) {
                        if (edge[0] == id && !nodeSet.contains(edge[1])) {
                            min = edge[2];
                            minIndex = edge[1];
                            minEdge = edge;
                        } else if (edge[1] == id && !nodeSet.contains(edge[0])) {
                            min = edge[2];
                            minIndex = edge[0];
                            minEdge = edge;
                        }
                    }
                }
            }
            sum += min;
            nodeSet.add(minIndex);
            edgeSet.remove(minEdge);
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int result = prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
