import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while(index < arr.length){
            list.add(arr.length - index);

            int min = arr[index];
            for(int i=index; i<arr.length; i++){
                arr[i] -= min;
            }

            int num = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i] == 0){
                    num++;
                }
            }
            index = num;
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
