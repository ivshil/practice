package p1.warmup;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int sockMerchant(int n, List<Integer> sL) {
        int sPairs = 0;
        LinkedList<Integer> socksList = new LinkedList<>();
        socksList.add(sL.get(0));
        for (int i = 1; i < n; i++) {
            if (!socksList.isEmpty()) {
                boolean madePair = false;
                for (int j = 0; j < socksList.size(); j++) {
                    if (socksList.get(j).equals(sL.get(i))) {
                        sPairs++;
                        madePair = true;
                        socksList.remove(j);
                        break;
                    }
                }
                if (!madePair) {
                    socksList.add(sL.get(i));
                }
            } else {
                socksList.add(sL.get(i));
            }
        }
        return sPairs;
    }
}

public class Task1_SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
//
        int result = Result.sockMerchant(n, ar);
        System.out.println(result);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
