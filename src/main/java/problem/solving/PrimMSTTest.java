package problem.solving;

public class PrimMSTTest {

    public static void main(String[] args) {

//        int[][] edges = {{2, 1, 1000}, {3, 4, 299}, {2, 4, 200}, {2, 4, 100}, {3, 2, 300}, {3, 2, 6}};
//        int n = 4;
//        int[][] edges = {{1, 2, 1}, {3, 2, 150}, {4, 3, 99}, {1, 4, 100}, {3, 1, 200}};
//        int n = 4;
        int[][] edges = {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        int n = 5;
//        int[][] edges = {{1, 2, 20}, {1, 3, 50}, {1, 4, 70}, {1, 5, 90}, {2, 3, 30}, {3, 4, 40}, {4, 5, 60}};
//        int n = 5;
        System.out.println(PrimMSTSolution1.prims(n, edges, 1));
        System.out.println(PrimMSTSolution2.prims(n, edges, 1));
        System.out.println(PrimMSTSolution3.prims(n, edges, 1));
    }
}
