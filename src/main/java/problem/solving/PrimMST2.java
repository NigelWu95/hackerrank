package problem.solving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 实现算法 2，加入一个新的 set 用于保存遍历过程中发现的端点均在已加入节点集合中的边，结束内层遍历后直接全部清除，尽可能减少最内存边遍历的次数，但时
 * 间复杂度仍然较高，依然为 O(n^4)
 */
public class PrimMST2 {

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {

        Set<Integer> nodeSet = new HashSet<Integer>(){{ add(start); }};
        Set<int[]> edgeSet = new HashSet<>();
        Set<int[]> toRmEdges = new HashSet<>();
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
            toRmEdges.clear();
            for (int id : nodeSet) {
                for (int[] edge : edgeSet) {
                    if (nodeSet.contains(edge[1]) && nodeSet.contains(edge[0])) {
                        toRmEdges.add(edge);
                        continue;
                    }
                    if (edge[2] < min) {
                        if (edge[0] == id) {
                            min = edge[2];
                            minIndex = edge[1];
                            minEdge = edge;
                        } else if (edge[1] == id) {
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
            edgeSet.removeAll(toRmEdges);
        }
        return sum;
    }
}
