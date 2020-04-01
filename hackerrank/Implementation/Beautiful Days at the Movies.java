import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int ans = 0;
        for(int num = i; num <= j; num++){
            char[] arr = String.valueOf(num).toCharArray();
            // 배열 뒤집기
            for(int index = 0; index<arr.length/2; index++){
                char temp = arr[index];
                arr[index] = arr[arr.length-1-index];
                arr[arr.length-1-index] = temp;
            }
            // 맨앞부터 연속적인 0제외 시키기
            boolean isZero = false;
            StringBuilder sb = new StringBuilder();
            if(arr[0] == '0'){
                isZero = true;
            } else {
                sb.append(arr[0]);
            }
            
            for(int index = 1; index<arr.length; index++){
                if(isZero){
                    if(arr[index] != '0'){
                        isZero = false;
                        sb.append(arr[index]);
                    }
                } else {
                    sb.append(arr[index]);
                }
            }

            int reverseNum = Integer.parseInt(sb.toString());
            if(Math.abs(reverseNum - num) % k == 0){
                ans++;
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
