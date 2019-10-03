package problem.solving;

import java.io.*;
import java.util.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        if (s == null) throw new RuntimeException("s is null");
        if (s.endsWith("AM")) {
            String time = s.substring(0, s.length() - 2);
            String[] units = time.split(":");
            if (units.length == 3) {
                int hour = Integer.parseInt(units[0]);
                int min = Integer.parseInt(units[1]);
                int sec = Integer.parseInt(units[2]);
                if (min < 0 || min > 59 || sec < 0 || sec > 59) {
                    throw new RuntimeException("s is not invalid format");
                }
                if (hour >= 0 && hour < 12) {
                    return time;
                } else if (hour == 12) {
                    return "00" + time.substring(2);
                } else {
                    throw new RuntimeException("s is not invalid format");
                }
            } else {
                throw new RuntimeException("s is not invalid format");
            }
        } else if (s.endsWith("PM")) {
            String time = s.substring(0, s.length() - 2);
            String[] units = time.split(":");
            if (units.length == 3) {
                int hour = Integer.parseInt(units[0]);
                int min = Integer.parseInt(units[1]);
                int sec = Integer.parseInt(units[2]);
                if (min < 0 || min > 59 || sec < 0 || sec > 59) {
                    throw new RuntimeException("s is not invalid format");
                }
                if (hour >= 0 && hour < 12) {
                    hour += 12;
                    return String.valueOf(hour) + time.substring(2);
                } else if (hour == 12) {
                    return time;
                } else {
                    throw new RuntimeException("s is not invalid format");
                }
            } else {
                throw new RuntimeException("s is not invalid format");
            }
        } else {
            throw new RuntimeException("s is not invalid format");
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
