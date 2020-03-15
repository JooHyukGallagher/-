import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the counterGame function below.
    static boolean isPower(long n){
        boolean flag = true;
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    static String counterGame(long n) {
        boolean louiseTurn = true;
        while(true){
            if(isPower(n)){
                n /= 2;
                if(n == 1){
                    break;
                }
                louiseTurn = !louiseTurn;
            } else {
                long powerNum = 1;
                while(powerNum < n){
                    powerNum *= 2;
                }
                powerNum = powerNum/2;
                n -= powerNum;
                if(n == 1){
                    break;
                }
                louiseTurn = !louiseTurn;
            }
        }

        if(louiseTurn){
            return "Louise";
        } else {
            return "Richard";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
