package problem.solving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 实现算法 2，加入一个新的 set 用于保存遍历过程中发现的端点均在已加入节点集合中的边，结束内层遍历后直接全部清除，尽可能减少最内存边遍历的次数，但时
 * 间复杂度仍然较高，依然为 O(n^3)
 */
public class PrimMSTSolution3 {

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {

        Set<Integer> nodeSet = new HashSet<Integer>(){{ add(start); }};
        int[][] nodes = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            if (edge.length != 3) {
                throw new RuntimeException("wrong edge: " + Arrays.toString(edge));
            } else {
                if (edge[0] > n || edge[1] > n) {
                    throw new RuntimeException("wrong node num: " + edge[0]);
                } else {
                    nodes[edge[0]][edge[1]] = edge[2];
                    nodes[edge[1]][edge[0]] = edge[2];
                    nodes[edge[0]][0]++;
                    nodes[edge[1]][0]++;
                }
            }
        }
        int sum = 0;
        int min;
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int id : nodeSet) {
                for (int in = 1; in < nodes[id].length; in++) {
                    if (nodeSet.contains(id) && nodeSet.contains(in)) {
                        continue;
                    }
                    if (id != in && nodes[id][in] > 0 && nodes[id][in] < min) {
                        min = nodes[id][in];
                        minIndex = in;
                    }
                }
            }
            sum += min;
            nodeSet.add(minIndex);
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
