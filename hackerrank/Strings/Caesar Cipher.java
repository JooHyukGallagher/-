import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            k %= 26;
            if(65 <= c && c <= 90){
                if(c + k > 90){
                    int element = 64 + (c+k) - 90;
                    sb.append((char)element);   
                } else {
                    sb.append((char)(c+k));
                }
            } else if(97 <= c && c <= 122){
                 if(c + k > 122){
                     int element = 96 + (c+k) - 122;
                    sb.append((char)element);   
                } else {
                    sb.append((char)(c+k));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
