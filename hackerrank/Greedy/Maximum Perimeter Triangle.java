import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static boolean isTrue(long first, long second, long third){
        if(first + second <= third){
            return false;
        }
        if(first + third <= second){
            return false;
        }
        if(second + third <= first){
            return false;
        }
        return true;
    }

    // Complete the maximumPerimeterTriangle function below.
    static long[] maximumPerimeterTriangle(long[] sticks) {
        long max = 0;
        Arrays.sort(sticks);

        long[] a = new long[3];
        for(int i=0; i<sticks.length-2; i++){
            if(isTrue(sticks[i], sticks[i+1], sticks[i+2])){
                if(max < sticks[i] + sticks[i+1] + sticks[i+2]){
                    max = sticks[i] + sticks[i+1] + sticks[i+2];
                    a[0] = sticks[i];
                    a[1] = sticks[i+1];
                    a[2] = sticks[i+2];
                }
            }
        }

        if(a[0] == 0 || a[1] == 0 || a[2] == 0){
            return new long[]{-1};
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] sticks = new long[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        long[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
