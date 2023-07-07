package p3.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result8 {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(prices.get(0));
//        for (int i = 1; i < prices.size(); i++) {
//            boolean ifTrue = true;
//            for (int j = 0; j < linkedList.size(); j++) {
//                if (linkedList.get(j) > prices.get(i)) {
//                    linkedList.add(j, prices.get(i));
//                    ifTrue = false;
//                    break;
//                }
//            }
//            if (ifTrue) {
//                linkedList.add(prices.get(i));
//            }
//        }
//        int numberOfToysBought = 0;
//        for (int i: linkedList) {
//            if (k - i >= 0) {
//                k = k - i;
//                numberOfToysBought++;
//            } else {
//                break;
//            }
//        }
        int numberOfToysBought = 0;

        List<Integer> sortedPrices = prices
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i :sortedPrices) {
            if (k - i >= 0) {
                k = k - i;
                numberOfToysBought++;
            } else {
                break;
            }
        }

        return numberOfToysBought;
    }

}

public class Task8_MarkAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result8.maximumToys(prices, k);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
