package p1_warmup;


import java.io.*;

class Result2 {

    public static int countingValleys(int steps, String path) {
        int currentPosition = 0;
        int numOfValleys = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D') {
                currentPosition--;
            } else {
                if (currentPosition+1 == 0) {
                    numOfValleys++;
                }
                currentPosition++;
            }
        }
        return numOfValleys;
    }

}
public class Task2_CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result2.countingValleys(steps, path);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        System.out.println(result);
        bufferedReader.close();
//        bufferedWriter.close();
    }
}
