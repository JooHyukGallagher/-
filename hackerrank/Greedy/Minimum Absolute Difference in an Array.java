import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int min = 1000000000;
        
        // -, +로 나누기
        Arrays.sort(arr);
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= 0){
                minus.add(arr[i]);
            }
            if(arr[i] >= 0){
                plus.add(arr[i]);
            }
        }

        int num;
        if(minus.size() == 1 && plus.size() == 1){
            num = Math.abs(minus.get(0) - plus.get(0));
            if(min > num){
                min = num;
            }
        } else if(minus.size() == 1){
            for(int i=0; i<plus.size()-1; i++){
                num = Math.abs(plus.get(i) - plus.get(i+1));
                if(min > num){
                    min = num;
                }
            }
        } else if(plus.size() == 1){
            for(int i=0; i<minus.size()-1; i++){
                num = Math.abs(minus.get(i) - minus.get(i+1));
                if(min > num){
                    min = num;
                }
            }
        } else {
            for(int i=0; i<plus.size()-1; i++){
                num = Math.abs(plus.get(i) - plus.get(i+1));
                if(min > num){
                    min = num;
                }
            }
            for(int i=0; i<minus.size()-1; i++){
                num = Math.abs(minus.get(i) - minus.get(i+1));
                if(min > num){
                    min = num;
                }
            }
        }

        return min;
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

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
