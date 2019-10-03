package problem.solving;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTriplesSolution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aPoints = 0;
        int bPoints = 0;
        int aLength = a.size();
        int bLength = b.size();
        if (aLength > bLength) {
            for (int i = 0; i < aLength; i++) {
                if (i > bLength || b.get(i) < a.get(i)) {
                    aPoints++;
                } else if (b.get(i) > a.get(i)) {
                    bPoints++;
                }
            }
        } else {
            for (int i = 0; i < bLength; i++) {
                if (i > aLength || a.get(i) < b.get(i)) {
                    bPoints++;
                } else if (a.get(i) > b.get(i)) {
                    aPoints++;
                }
            }
        }
        List<Integer> points = new ArrayList<Integer>();
        points.add(aPoints);
        points.add(bPoints);
        return points;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

