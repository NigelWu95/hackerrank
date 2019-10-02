package problem.solving;

import java.util.*;

/**
 * 实现算法 1，使用 set 记录已经加入的节点，并且使用 set 来保存所有遍，便于减少节点遍历范围，并且在内层遍历之后剔除已使用的边，但时间复杂度仍然较
 * 高，为 O(n^4)，因为 n 个节点，边的个数遍历一遍就是 O(n^2)
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
}
