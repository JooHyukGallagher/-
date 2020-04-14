import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        if(n < 3){
            System.out.println("-1");
            return;
        }

        if(n % 3 == 0 && n % 5 == 0){
            for(int i=0; i<n/3; i++){
                System.out.print("555");
            }
            System.out.println();
            return;
        } else {
            int i;
            for(i=n; i>=0; i--){
                if(i % 3 == 0 && (n-i) % 5 == 0){
                    for(int j=0; j<i/3; j++){
                        System.out.print("555");
                    }
                    for(int j=0; j<(n-i)/5; j++){
                        System.out.print("33333");
                    }
                    System.out.println();
                    return;
                }
            }
            if(i == -1){
                System.out.println("-1");
                return;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
