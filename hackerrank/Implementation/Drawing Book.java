import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int odd(int n, int p){
        if(p == 1){
            return 0;
        }

            // 처음 부터
            int first = 0;
            for(int i=2; i<=n; i+=2){
                first++;
                if(i <= p && p <= i+1){
                    break;
                }
            }            

            // 마지막 부터
            int last = 0;
            for(int i=n; i>=1; i-=2){
                if(i-1 <= p && p <=i){
                    break;
                }
                last++;
            }

        return first > last ? last : first;
    }

    static int even(int n, int p){
        if(p == 1){
            return 0;
        }
        
            // 처음 부터
            int first = 0;
            for(int i=2; i<=n; i+=2){
                first++;
                if(i <= p && p <= i+1){
                    break;
                }
            }

        if(p == n) {
            return 0;
        }

            // 마지막 부터
            int last = 0;
            for(int i=n-1; i>=1; i-=2){
                last++;
                if(i-1 <= p && p <=i){
                    break;
                }
            }

        return first > last ? last : first;
    }
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
         if(n % 2 == 0){
             return even(n, p);
         } else {
             return odd(n, p);
         }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
