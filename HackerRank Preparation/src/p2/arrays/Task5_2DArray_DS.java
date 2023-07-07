package p2.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arrList) {
        int max = -2147483648;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int sum = arrList.get(i).get(j) + arrList.get(i-1).get(j) + arrList.get(i-1).get(j-1) + arrList.get(i-1).get(j+1) +
                        arrList.get(i+1).get(j) + arrList.get(i+1).get(j-1) + arrList.get(i+1).get(j+1);;
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

}

public class Task5_2DArray_DS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result5.hourglassSum(arr);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
