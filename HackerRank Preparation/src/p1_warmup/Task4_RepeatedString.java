package p1_warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result4 {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        long t = 0; // mumber of a's in String s
        long r = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                t++;
            }
        }
        long k = n/s.length();
        if (k * s.length() == n) {
            return k * t;
        } else {
            long num = n - k * s.length();
            for (int i = 0; i < num; i++) {
                if (s.charAt(i) == 'a') {
                    r++;
                }
            }
            return k * t + r;
        }
    }

}

public class Task4_RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result4.repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        System.out.println(result);
        bufferedReader.close();
//        bufferedWriter.close();
    }
}
