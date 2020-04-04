import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        int length = orders.length;

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        
        int[] time = new int[length];
        for(int i=0; i<length; i++){
            time[i] = orders[i][0] + orders[i][1];
        }
      
        int[] ans = new int[length];
        boolean[] check = new boolean[length];
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i=0; i<length; i++){
            min = Integer.MAX_VALUE;
            for(int j=0; j<length; j++){
                if(min > time[j] && !check[j]){
                    min = time[j];
                    minIdx = j;
                }
            }
            check[minIdx] = true;
            ans[i] = minIdx+1;
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

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
