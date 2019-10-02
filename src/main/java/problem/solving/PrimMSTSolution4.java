package problem.solving;

import java.util.Arrays;

/**
 * 实现算法 4，使用一个 (n+1)*(n+1) 的新二维数组，数据下标表示节点标号，遍历边的数组，然后将每个节点存在的边联系都存在数组中，同时在每个节点的 0
 * 下标位置保存距离该边最短的断点编号。在这个二维数组的 0 下标位置保存标志位，初始位 0，记录位 1 时表示已经加入图中，从节点遍历过程中直接利用最近的
 * 端点编号来得到最小距离，降低时间复杂度为 O(n^2)
 */
public class PrimMSTSolution4 {

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {

        int[][] nodes = new int[n + 1][n + 1];
        // 测试数据中有节点边长为 0 的情况，所以加一个初始化操作让所有边长初始值为最大值
        for (int i = 1; i < nodes.length; i++) {
            for (int in = 1; in < nodes.length; in++) {
                nodes[i][in] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            if (edge.length != 3) {
                throw new RuntimeException("wrong edge: " + Arrays.toString(edge));
            } else {
                if (edge[0] > n || edge[1] > n) {
                    throw new RuntimeException("wrong node num: " + edge[0]);
                } else {
                    nodes[edge[0]][edge[1]] = edge[2];
                    nodes[edge[1]][edge[0]] = edge[2];
                    if (nodes[edge[0]][0] == 0 || edge[2] < nodes[edge[0]][nodes[edge[0]][0]]) {
                        nodes[edge[0]][0] = edge[1];
                    }
                    if (nodes[edge[1]][0] == 0 || edge[2] < nodes[edge[1]][nodes[edge[1]][0]]) {
                        nodes[edge[1]][0] = edge[0];
                    }
                }
            }
        }
        nodes[0][start] = 1;
        int sum = 0;
        int min;
        int mid = 0;
        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int id = 1; id < nodes.length; id++) {
                if (nodes[0][id] > 0) {
                    if (nodes[0][nodes[id][0]] == 0) {
                        mid = nodes[id][0];
                        min = nodes[id][mid];
                    } else {
                        for (int in = 1; in < nodes[id].length; in++) {
                            if (nodes[id][in] < min && nodes[0][in] == 0) {
//                            // 如果数组初始化的值为 0 则需要判断 nodes[id][in] > 0
//                            if (nodes[id][in] > 0 && nodes[id][in] < min && nodes[0][in] == 0) {
                                mid = in;
                                min = nodes[id][in];
                            }
                        }
                    }
                }
            }
            sum += min;
            nodes[0][mid] = 1;
        }
        return sum;
    }
}
