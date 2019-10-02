package problem.solving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 实现算法 3，使用新二维数组，数据下标表示节点标号，每个节点存在的边关系都存在数组中，在遍历过程中直接取已加入节点的边数组来遍历找到最小值，尽可能减
 * 少最内存边遍历的次数，时间复杂度为 O(n^3)
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
}
