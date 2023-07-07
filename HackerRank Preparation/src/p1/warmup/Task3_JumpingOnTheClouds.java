package p1.warmup;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result3 {

    public static int jumpingOnClouds(List<Integer> c) {
        int curPos = 0;
        int jumps = 0;
        while (true) {
            if (curPos >= c.size()-1) {
                break;
            } else if (curPos>= c.size()-3) {
                jumps++;
                break;
            }
            if (c.get(curPos+2) == 0) {
                    curPos+=2;
                    jumps++;
                } else {
                    curPos++;
                    jumps++;
                }
            }
        return jumps;
    }
}

public class Task3_JumpingOnTheClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result3.jumpingOnClouds(c);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println(result);
        bufferedReader.close();
//        bufferedWriter.close();
    }
}
