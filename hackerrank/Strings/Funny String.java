import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        // 순서 바꾸기
        int length = s.length();
        char[] carr = s.toCharArray();
        char[] ncarr = new char[length];
        for(int i=0; i<length; i++){
            ncarr[i] = carr[length-1-i];
        }

        boolean ok = true;
        for(int i=0; i<length-1; i++){
            int dif1 = Math.abs(carr[i+1] - carr[i]);
            int dif2 = Math.abs(ncarr[i+1] - ncarr[i]);
            if(dif1 != dif2){
                ok = false;
                break;
            }
        }

        if(ok) {
            return "Funny";
        } else {
            return "Not Funny";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
